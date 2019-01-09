package WJP_GraEdukacyjna;

import javax.swing.JPanel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.DecimalFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;



/**
 * Główny panel graficzny gry
 * @author Julianna Wichowska
 */
public class GamePanel extends JPanel {
    //szerokość pola graficznego
    public int sWidth;
    //wysokośc pola graficznego
    public int sHeight;
    //obiekt reprezentujący status gry
    public GameStatus gStatus;
    //wysokość paska menu
    public int barHeight;
    //czcionka stosowana w menu
    public Font menuFont;
    //czcionki stosowane na koniec gry
    public Font endFont;
    // czcionka do wyswietlania kraju
    public Font countryFont;
    //czcionka do wyświetlania pytań
    public Font questionsFont;
    //czcionka do wyświetlania odpowiedzi
    public Font answersFont;
    //czcionka do wyświetlania informacji w polu
    public Font infFont;
    
    private GameMap m;
    private GamePlayer p;

    /**
     * Konstruktor klasy pola graficznego.
     * Zawiera ustawienia początkowe oraz 
     * obsługe zdarzeń generowanych przez mysze w polu graficznym gry.
     * @param width szerokość pola graficznego
     * @param height wysokość pola graficznego
     */
    public GamePanel(int width, int height){

        //dodanie nowych czcionek 
        menuFont = new Font("Monospaced",Font.BOLD,36);
        endFont=new Font("Monospaced",Font.BOLD,70);
        countryFont = new Font ("SansSerif",Font.BOLD, 60);
        questionsFont = new Font ("Dialog", Font.BOLD,38);
        answersFont = new Font("Dialog", Font.BOLD, 20);
        infFont = new Font("Monospaced", Font.BOLD,48);
        
        //rozpoczęcie gry
        gStatus=new GameStatus();
        gStatus.reset();
        GameConst.loadTables();
        GameQuiz.QuestionsAnswers();
        gStatus.gameStarted = true;
        
        this.sWidth=width;
        this.sHeight=height;
        barHeight=40;
        m = new GameMap();
        p = new GamePlayer();
        addKeyListener(new Al()); //obsługa zdarzenia generowanego przez klawiaturę
        setFocusable(true);
        
        // dodanie obslugi zdarzenia wciśnięcia mmyszki
        addMouseListener (new MouseAdapter(){
            public void mouseClicked(MouseEvent me){
        
                //jesli wybrano MENU
                if(me.getX()>(sWidth-150) && me.getY()>(sHeight-barHeight)){
                    GameConst.pause=!GameConst.pause;
                        if( gStatus.levelWon==0){
                            gStatus.levelWon=1;
                        }
                        else{
                            gStatus.levelWon=0;
                        }
                }
                
                //jeśli wybrano z MENU opcję KONIEC GRY
                if(me.getX()<300 && me.getY()>(sHeight-barHeight)){
                    if(GameConst.pause){
                        System.exit(1);
                    }
                }
              
                //jeśli wybrano z MENU opcję NOWA GRA 
                if(me.getX()>350 && me.getX()<500 && me.getY()>(sHeight-barHeight)){
                    if(GameConst.pause){
                        GameConst.level=1;
                        GameConst.end=false;
                        gStatus.reset();
                        GameConst.levelPause=false;
                        p.resetMovement();
                        gStatus.levelWon = 0;
                        gStatus.showTime = true;
                        repaint();
                    }        
                }
                //jeśli wybrano rozpoczęcie kolejnego poziomu
                if(me.getX()>685 && me.getX()<1205 && me.getY() >595 && me.getY() <640){
                    if(GameConst.levelPause){
                        //Czy dostępny jest kolejny poziom
                        if (GameConst.level<GameConst.NO_LEVELS){
                            GameConst.level++;
                            GameConst.levelPause=false;
                            gStatus.time += GameConst.levelTime;
                            GameConst.startTime=System.currentTimeMillis();
                            gStatus.showTime = true;
                            p.resetMovement();  
                        } else {
                        //jeśli koniec poziomów
                            GameConst.end=true;
                            gStatus.time+=GameConst.levelTime;
                            GameConst.pause=true;
                        }
                        repaint();
                        gStatus.levelWon = 0;
                    }
                }
                  
            }
        });
    }
    
    //
    public void actionPerformed(ActionEvent e) {
    repaint();
    };
    
    //dodanie obsługi uzycia klawiatury
    public class Al extends KeyAdapter{
        public void keyPressed(KeyEvent e){
            int keycode = e.getKeyCode(); 

            //jeśli gracz nie dotarł do poprawnej odpowiedzi
            if(gStatus.levelWon != 1){

                //jeśli wykonano ruch zacznij grę
                if(gStatus.gameStarted == true){
                    startTime();
                }

                //jeśli kliknięto strzałkę w góre przemieszcz gracza o jedną pozycję w górę
                if(keycode == KeyEvent.VK_UP){
                    if(!m.getMap(p.getTileX(),p.getTileY()-1 ).equals("w")){
                        p.move(0, -1);
                    }
                } 
                
                //jeśli kliknięto strzałkę w dół przemieszcz gracza o jedną pozycję w dół
                if(keycode == KeyEvent.VK_DOWN){
                    if(!m.getMap(p.getTileX(),p.getTileY()+1 ).equals("w")){
                        p.move(0, 1);
                    }
                }
                
                //jeśli kliknięto strzałkę w lewo przemieszcz gracza o 1 pozycję w lewo
                if(keycode == KeyEvent.VK_LEFT){
                    if(!m.getMap(p.getTileX()-1,p.getTileY()).equals("w")){
                        p.move(-1, 0);
                    }
                }
                
                //jeśli kliknięto strzałkę w prawo przemieszcz gracza o 1 pozycję w prawo
                if(keycode == KeyEvent.VK_RIGHT){
                    if(!m.getMap(p.getTileX()+1,p.getTileY()).equals("w")) {
                        p.move(1, 0);
                    }
                } 
                
                //jeśli wybrano poprawnąodpowiedź
                if(m.getMap(p.getTileX(),p.getTileY()).equals("n")) {
                        gStatus.levelWon=1;
                        gStatus.points += 300;
                        playSound(new File("Sounds/goodAnswer.wav"));
                        gStatus.showTime= false;
                }
                
                //jeśli wybrano niepoprawną odpowiedź
                if(m.getMap(p.getTileX(),p.getTileY()).equals("m")) {
                        p.resetMovement();
                        gStatus.levelWon = 2; 
                        gStatus.points -= 150;
                        playSound(new File("Sounds/badAnswer.wav"));
                }
            }  
        }
    }

    /**
     * Wypełnienie graficzne pola gry, metoda odpowiadająca 
     * za odrysowanie aktualnego panelu zgodnie z aktualnym poziomem gry
     * @param gs 
     */
    protected void paintComponent(Graphics gs){
        Graphics2D g=(Graphics2D)gs;
        //Ustaw tryb lepszej jakości grafiki 
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //pobranie domyślnego kursora myszki
        Toolkit tk = Toolkit.getDefaultToolkit(); 
        
        if (GameConst.level == 1){  

            //Narysuj tło i wyświetl zdjęcie kraju
            g.drawImage(GameConst.Background1, 0, 0, null); 
            g.drawImage(GameConst.Switzerland,870,100, null);

            //Wyświetl nazwę kraju
            g.setFont(countryFont);
            g.setColor(Color.white);
            g.drawString("SZWAJCARIA", 800, 70);

            //Wyświetl pytanie
            g.setColor(Color.black);
            g.setFont(questionsFont);
            //jeśli gra się zaczęła - wyłączono instrukcję
            if(gStatus.showGame == true){
                g.drawString("PYTANIE: " + GameQuiz.QuestionsS[0][0], 50, 780);
            }

            //Wyświetl odpowiedzi
            g.setFont(answersFont);
            //jeśli gra się zaczęła - wyłączono instrukcję
            if(gStatus.showGame == true){
                g.drawString(GameQuiz.QuestionsS[0][1], 620, 125);
                g.drawString(GameQuiz.QuestionsS[0][2], 620, 505);
                g.drawString(GameQuiz.QuestionsS[0][3], 165, 650);
            }
            
            //Ustaw ikonke myszki
            Cursor tCursor = tk.createCustomCursor(GameConst.cursorImage1, new Point(10,10), "Target Cursor");
                setCursor(tCursor);
                
            //Ustaw kolor MENU   
            g.setColor(new Color(255,162,138));
       }
        
       if (GameConst.level == 2){
        
           //Narysuj tło i wyświetl zdjęcie kraju
            g.drawImage(GameConst.Background2, 0, 0, null);
            g.drawImage(GameConst.Iceland,870,100, null);

            //Wyświetl nazwę kraju
            g.setFont(countryFont);
            g.setColor(Color.white);
            g.drawString("ISLANDIA", 850, 70);
            
            //Wyświetl pytanie
            g.setColor(Color.black);
            g.setFont(questionsFont);
            g.drawString("PYTANIE: " + GameQuiz.QuestionsI[0][0], 50, 780);
            
            //Wyświtl opowiedzi
            g.setFont(answersFont);
            g.drawString(GameQuiz.QuestionsI[0][1], 620, 470);
            g.drawString(GameQuiz.QuestionsI[0][2], 280, 650);
            g.drawString(GameQuiz.QuestionsI[0][3], 55, 650);

            //Ustaw ikonkę myszki
            Cursor tCursor = tk.createCustomCursor(GameConst.cursorImage2, new Point(10,10), "Target Cursor");
                setCursor(tCursor);

            //Ustaw kolor MENU
            g.setColor(new Color(183,110,189));    
           }
  
        if (GameConst.level == 3) {

            //Narysuj tło i wyświetl zdjęcie kraju
            g.drawImage(GameConst.Background3, 0, 0, null);
            g.drawImage(GameConst.Albania,870,100, null);

            //Wyświetl nazwę kraju
            g.setFont(countryFont);
            g.setColor(Color.white);
            g.drawString("ALBANIA", 850, 70);

            //Wyświetl pytanie
            g.setColor(Color.black);
            g.setFont(questionsFont);
            g.drawString("PYTANIE: " + GameQuiz.QuestionsA[0][0], 50, 780);

            //Wyświtl opowiedzi
            g.setFont(answersFont);
            g.drawString(GameQuiz.QuestionsA[0][1], 620, 90);
            g.drawString(GameQuiz.QuestionsA[0][2], 620, 480);
            g.drawString(GameQuiz.QuestionsA[0][3], 275, 650);

            //Ustaw ikonkę myszki
            Cursor tCursor = tk.createCustomCursor(GameConst.cursorImage3, new Point(10,10), "Target Cursor");
                setCursor(tCursor);
                
            //Ustaw kolor MENU
            g.setColor(new Color(105,194,181));  
           }

           //odczyt plików tekstowych
           m.openFile();
           m.readFile();
           m.closeFile();
       
        //rysowanie labiryntu
        for (int y = 0; y<19; y++){
            for(int x=0; x<19; x++){
                
                if(m.getMap(x, y).equals("t")){
                    g.drawImage(m.getTrack(), (x*32), (y*32) ,null);}
                
                if(m.getMap(x, y).equals("w")){
                    g.drawImage(m.getWall(), (x*32), (y*32) ,null);}
                
                if(m.getMap(x, y).equals("m")){
                    g.drawImage(m.getGoal(), (x*32), (y*32) ,null);}
                
                if(m.getMap(x, y).equals("n")){
                    g.drawImage(m.getGoal(), (x*32), (y*32) ,null);}
            }
        }
        
        //rysowanie ikonki gracza
        g.drawImage(GameConst.player,p.getTileX()*32, p.getTileY()*32, null);
   

        //narysuj dolne MENU
        g.fillRect(0, sHeight-barHeight,250, barHeight);
        g.fillRect(1100, sHeight-barHeight,180, barHeight);
        g.fillRect(325, sHeight-barHeight,270, barHeight);
        g.fillRect(710, sHeight-barHeight,290, barHeight);
        g.setColor(Color.white);
        g.setFont(menuFont);
        
        //jeśli wybrano MENU
        if(GameConst.pause){
            g.setColor(Color.black);
            g.drawString("KONIEC GRY",10,sHeight-10);
            g.setColor(Color.white);
            g.drawString("NOWA GRA!",350, sHeight-10);
            g.drawString("MENU",1130, sHeight-10); 

            //jeśli ukończono grę
            if(GameConst.end){ 
                g.setColor(Color.white);
                g.setFont(endFont);
                g.drawImage(GameConst.Background4, 0, 0, null);
                DecimalFormat df = new DecimalFormat("#.##");
                g.drawString("Brawo! Ukończyłeś grę ",170, 200);
                g.drawString("Łączny czas gry ->  "+df.format(gStatus.time)+"s",100,400);
                g.drawString("Łączna ilość punktów ->  "+(gStatus.points),30, 600);
                g.setFont(answersFont);
                g.drawString("Aby zacząć nową grę kliknij NOWA GRA, aby zakończyć grę klinij KONIEC GRY",10, 800);        
                g.setColor(Color.white);
                g.setFont(questionsFont);
                g.drawString("KONIEC GRY",10,sHeight-10);
                g.drawString("NOWA GRA!",350, sHeight-10);
            }
        //jeśli nic nie wybrano z MENU  
        }else{
            g.drawString("MENU",1130, sHeight-10); 
            g.drawString(" POZIOM:"+GameConst.level,10, sHeight-10); 
            g.drawString("PUNKTY:"+gStatus.points,350, sHeight-10);
            DecimalFormat df = new DecimalFormat("#.##");
            if(gStatus.showTime == false){}
            else{
                g.drawString(" CZAS: " +df.format((System.currentTimeMillis()-GameConst.startTime)/1000.0)+"s",700,sHeight-10);
            }
            //jesli ukończono aktualny poziom
            if(gStatus.levelWon == 1){
                if(!GameConst.levelPause){
                    long stopTime = System.currentTimeMillis();
                    GameConst.levelTime=(stopTime-GameConst.startTime)/1000.0;
                    GameConst.levelPause=true;
                }
                g.setFont(infFont);
                g.setColor(Color.black);
                g.drawString("KOLEJNY POZIOM ->",700, 630);
                g.setColor(Color.white);
                g.drawString("POPRWNA ODPOWIEDŹ!",700, 390);
                g.drawString(" CZAS: " +df.format(GameConst.levelTime)+"s",720, 440);
                g.setColor(Color.white);
            }
            //jeśli wybrano złą odpwoiedź
            if  (gStatus.levelWon == 2){
                g.setColor(Color.white);
                g.setFont(infFont);
                g.drawString("NIEPOPRAWNA ODPOWIEDŹ",630, 390);
                g.drawString("SPRÓBUJ PONOWNIE!",690, 440);
            
             }

        }
    }
    
        
    
    /**
     * Metoda inicjująca pomiar czasu i ukazanie się pytania po wyłączeniu instrukcji 
     */
    private void startTime(){
        if (gStatus.gameStarted == true){ 
            GameConst.startTime = System.currentTimeMillis(); 
            gStatus.showTime = true;
            gStatus.showGame = true;
            gStatus.gameStarted = false;
        }
    }
    
    /**
     * Metoda generująca dźwięk przy odpowiedzi na pytanie
     * @param f 
     */
    public static synchronized void playSound(final File f) {
        new Thread(new Runnable() {
          public void run() {
            try {
              Clip clip = AudioSystem.getClip();
              AudioInputStream inputStream = AudioSystem.getAudioInputStream(f);
              clip.open(inputStream);
              clip.start(); 
            } catch (Exception e) {
              System.err.println(e.getMessage());
            }
          }
        }).start();
    }
    
}