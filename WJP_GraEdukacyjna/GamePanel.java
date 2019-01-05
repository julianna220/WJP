
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
import java.text.DecimalFormat;



/**
 *
 * @author Lucek
 */
public class GamePanel extends JPanel {
    // szerokość pola graficznego
    public int sWidth;
    //wysokośc pola graficznego
    public int sHeight;
    //obiekt reprezentujący status gry
    public GameStatus gStatus;
    public GameQuiz gQuiz;
    //wysokość paska menu
    public int barHeight;
    //czcionka stosowana w menu
    public Font menuFont;
    //czcionki stosowane w polu gry jako alert
    public Font alertFont;
    // czcionka do wyswietlania danych kra
    public Font countryFont;
    //czcionka do wyświetlania pytań
    public Font questionsFont;
    public Font answersFont;
    public Font infFont;
    
    private GameMap m;
    private GamePlayer p;


    

    
    
    public GamePanel(int width, int height){
         gStatus=new GameStatus();
         gStatus.reset();
         menuFont = new Font("Monospaced",Font.BOLD,36);
        alertFont=new Font("Monospaced",Font.BOLD,92);
        countryFont = new Font ("SansSerif",Font.BOLD, 60);
        questionsFont = new Font ("Dialog", Font.BOLD,40);
        answersFont = new Font("Dialog", Font.BOLD, 20);
        infFont = new Font("Monospaced", Font.BOLD,48);
        GameConst.loadTables();
        GameQuiz.QuestionsAnswers();
        
        this.sWidth=width;
        this.sHeight=height;
        barHeight=40;
        

        
       //gQuiz.QuestionsAnswers();
        
        
        //c=Color.YELLOW;
        //x=512;
        //y=380;
        
        
        m = new GameMap();
        p = new GamePlayer();
        addKeyListener(new Al());
        setFocusable(true);

        
        
        // dodanie obslugi zdarzenia wciśnięcia mmyszki
        addMouseListener (new MouseAdapter(){
            public void mouseClicked(MouseEvent me){
        
                if(me.getX()>(sWidth-150) && me.getY()>(sHeight-barHeight)){
                  GameConst.pause=!GameConst.pause;
                  return;
        }
                //Czy wybrano z Menu pozycję Koniec gry
              if(me.getX()<300 && me.getY()>(sHeight-barHeight)){
                  if(GameConst.pause){
                      System.exit(1);
       }
      }
              
               if(me.getX()>350 && me.getX()<500 && me.getY()>(sHeight-barHeight)){
                   //Nowa gra
                      if(GameConst.pause){
                          GameConst.MoveMODE=1;
                          GameConst.end=false;
                          gStatus.reset();
                          GameConst.levelPause=false;
                          restartGame();
                          p.resetMovement();
                          gStatus.levelWon = 0;
                          repaint();
               }}
              //czy wybrano rozpoczęcie nowego poziomu lub nowej gry
              if(me.getX()>685 && me.getX()<1205 && me.getY() >595 && me.getY() <640){

                      
                          if(GameConst.levelPause){
                              //Czy dostępny jest kolejny poziom
                              if (GameConst.MoveMODE<GameConst.NO_LEVELS){
                                  GameConst.MoveMODE++;
                                  
                                  gStatus.time+=GameConst.levelTime;
                                  GameConst.levelPause=false;
                                  gStatus.nextLevel();
                                  p.resetMovement();
                              }else{
                                  //koniec poziomĂłw = koniec gry
                                  GameConst.end=true;
                                  gStatus.time+=GameConst.levelTime;
                                  GameConst.pause=true;
                              }
                              repaint();
                              gStatus.levelWon = 0;
                          }
                      }
                  
              }});}
            public void actionPerformed(ActionEvent e) {
        repaint();
    };
       
            
            
            
public class Al extends KeyAdapter{
    public void keyPressed(KeyEvent e){
        int keycode = e.getKeyCode(); 
        
        if(gStatus.levelWon == 0 || gStatus.levelWon == 2){
         
        if(keycode == KeyEvent.VK_UP){
            if(!m.getMap(p.getTileX(),p.getTileY()-1 ).equals("w")){
                p.move(0, -1);
        }
        } 
        if(keycode == KeyEvent.VK_DOWN){
            if(!m.getMap(p.getTileX(),p.getTileY()+1 ).equals("w")){
                p.move(0, 1);
        }
        }
        if(keycode == KeyEvent.VK_LEFT){
            if(!m.getMap(p.getTileX()-1,p.getTileY()).equals("w")){
                p.move(-1, 0);
        }
        }
        if(keycode == KeyEvent.VK_RIGHT){
            if(!m.getMap(p.getTileX()+1,p.getTileY()).equals("w")) {
                p.move(1, 0);
        }
        }    
        if(m.getMap(p.getTileX(),p.getTileY()).equals("n")) {
                gStatus.levelWon=1;
                gStatus.points += 300;
        }
        if(m.getMap(p.getTileX(),p.getTileY()).equals("m")) {
                p.resetMovement();
                gStatus.levelWon = 2; 
                gStatus.points -= 150;
        }
 
        }  
}
    public void keyRelased (KeyEvent e){
    }
    
    public void keyTyped (KeyEvent e){
    }
}

    
    protected void paintComponent(Graphics gs){
        Graphics2D g=(Graphics2D)gs;
        //Ustaw tryb lepszej jakoĹ›ci grafiki (wygĹ‚adzanie/antyaliasing)
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // Narysuj tło
        //g.drawImage(GameConst.Background1, 0, 0, null);
        Toolkit tk = Toolkit.getDefaultToolkit();
        
        /*if(GameConst.instruction){
            g.drawString("HALKOOOO", 800, 600);
        }*/
        
        
      if (GameConst.MoveMODE == 1){   
          
        g.drawImage(GameConst.Background1, 0, 0, null); 
        g.drawImage(GameConst.Switzerland,870,100, null);
        
        g.setFont(countryFont);
        g.setColor(Color.white);
        g.drawString("SZWAJCARIA", 800, 70);
        
        g.setColor(Color.black);
        g.setFont(questionsFont);
        g.drawString("PYTANIE : " + GameQuiz.QuestionsS[0][0], 60, 780);
    
        g.setFont(answersFont);
        g.drawString(GameQuiz.QuestionsS[0][1], 620, 125);
        g.drawString(GameQuiz.QuestionsS[0][2], 620, 505);
        g.drawString(GameQuiz.QuestionsS[0][3], 165, 650);
        
        Cursor tCursor = tk.createCustomCursor(GameConst.cursorImage1, new Point(10,10), "Target Cursor");
            setCursor(tCursor);
            
        g.setColor(new Color(255,162,138));


       }
       if (GameConst.MoveMODE == 2){
            
        g.drawImage(GameConst.Background2, 0, 0, null);
        g.drawImage(GameConst.Iceland,870,130, null);
        
        g.setFont(countryFont);
        g.setColor(Color.white);
        g.drawString("ISLANDIA", 850, 70);

        g.setColor(Color.black);
        g.setFont(questionsFont);
        g.drawString("PYTANIE : " + GameQuiz.QuestionsI[0][0], 100, 780);

        g.setFont(answersFont);
        g.drawString(GameQuiz.QuestionsI[0][1], 620, 125);
        g.drawString(GameQuiz.QuestionsI[0][2], 620, 505);
        g.drawString(GameQuiz.QuestionsI[0][3], 165, 650);

        Cursor tCursor = tk.createCustomCursor(GameConst.cursorImage2, new Point(10,10), "Target Cursor");
            setCursor(tCursor);
            
        g.setColor(new Color(200,62,138));    
           }
       
               
       
       
    if (GameConst.MoveMODE == 3) {
           
        g.drawImage(GameConst.Background3, 0, 0, null);
        g.drawImage(GameConst.Albania,870,130, null);
        
        g.setFont(countryFont);
        g.setColor(Color.white);
        g.drawString("ALBANIA", 850, 70);

        g.setColor(Color.black);
        g.setFont(questionsFont);
        g.drawString("PYTANIE : " + GameQuiz.QuestionsA[0][0], 100, 780);
        
        g.setFont(answersFont);
        g.drawString(GameQuiz.QuestionsA[0][1], 620, 125);
        g.drawString(GameQuiz.QuestionsA[0][2], 620, 505);
        g.drawString(GameQuiz.QuestionsA[0][3], 165, 650);

        Cursor tCursor = tk.createCustomCursor(GameConst.cursorImage3, new Point(10,10), "Target Cursor");
            setCursor(tCursor);
       }
    
    
    m.openFile(GameConst.MoveMODE);
           m.readFile();
           m.closeFile();
        
        for (int y = 0; y<19; y++){
            for(int x=0; x<19; x++){
                
                if(m.getMap(x, y).equals("g")){
                    g.drawImage(m.getGrass(), (x*32), (y*32) ,null);}
                
                if(m.getMap(x, y).equals("w")){
                    g.drawImage(m.getWall(), (x*32), (y*32) ,null);}
                
                if(m.getMap(x, y).equals("m")){
                    g.drawImage(m.getMeta(), (x*32), (y*32) ,null);}
                
                if(m.getMap(x, y).equals("n")){
                    g.drawImage(m.getMeta(), (x*32), (y*32) ,null);}
            }
        }
        g.drawImage(p.getPlayer(),p.getTileX()*32, p.getTileY()*32, null);
   

        //Ustaw kolor dolnego paska Menu i narysuj pasek
        //g.setColor(new Color(255,162,138));
        g.fillRect(0, sHeight-barHeight,250, barHeight);
        g.fillRect(1100, sHeight-barHeight,180, barHeight);
        g.fillRect(325, sHeight-barHeight,270, barHeight);
        //Ustaw kolor domyĹ›lny
        g.setColor(Color.white);
        //Ustaw czcionki do wypeĹ‚nienia paska Menu
        g.setFont(menuFont);
        
        //JeĹ›li juĹĽ wybrano Menu (czyli pausa) narysuj stosownÄ… wersjÄ™ paska Menu
        if(GameConst.pause){
            g.setColor(Color.black);
            g.drawString("KONIEC GRY",10,sHeight-10);
            g.setColor(Color.white);
            g.drawString("NOWA GRA!",350, sHeight-10);
            g.drawString("MENU",1150, sHeight-10); 
            if(GameConst.instruction){
            g.drawString("HALKOOOO", 800, 600);
            }
            if(GameConst.end){ 
        //Czy wszystkie poziomy skoĹ„czone - koniec gry
                g.setColor(Color.RED);
                //g.drawString("KONIEC?",500, sHeight-10);
                g.setFont(alertFont);
                DecimalFormat df = new DecimalFormat("#.##");
                g.drawString("KONIEC GRY! ",170, sHeight/2);
                g.drawString("CZAS RAZEM="+df.format(gStatus.time)+"s",10, sHeight/2+100);
                g.setColor(Color.white);
                g.setFont(menuFont);
            }
        //Nie wybranu nic z menu - pokaż poziom i stan punktów w trakcie gry  
        }else{
            g.drawString("MENU",1150, sHeight-10); 
            g.drawString(" POZIOM:"+gStatus.level,10, sHeight-10); 
            g.drawString("PUNKTY:"+gStatus.points,350, sHeight-10);
            DecimalFormat df = new DecimalFormat("#.##");
            g.drawString(" CZAS: " +df.format(System.currentTimeMillis()-GameConst.startTime)+"s",700,sHeight-10);
            // Czy ukoĹ„czono poziom - wskazano wszystkie obiekty pozciomu 
            if(gStatus.levelWon == 1){
                if(!GameConst.levelPause){
                    long stopTime = System.currentTimeMillis();
                    GameConst.levelTime=(stopTime-GameConst.startTime)/1000.0;
                    GameConst.levelPause=true;
                }
                g.setColor(new Color(255,162,138));
                g.fillRect(685, 595,520,45);
                g.setFont(infFont);
                g.setColor(Color.white);
                g.drawString("KOLEJNY POZIOM ->",700, 630);
                g.drawString("POPRWNA ODPOWIEDŹ!",700, 390);
                //DecimalFormat df = new DecimalFormat("#.##");
                g.drawString(" CZAS: " +df.format(GameConst.levelTime)+"s",720, 440);
                g.setColor(Color.white);

            }
            // Jeśli wybrano złą odpwoiedź
            if  (gStatus.levelWon == 2){
                g.setColor(Color.white);
                g.setFont(infFont);
                g.drawString("NIEPOPRWNA ODPOWIEDŹ",650, 390);
                g.drawString("SPRÓBUJ PONOWNIE!",690, 440);
            
        }

        }}
    
    private void restartGame(){
        gStatus.resetPoints();
        GameConst.startTime=System.currentTimeMillis();
        GameConst.pause=false;
       
        
    }
    
}