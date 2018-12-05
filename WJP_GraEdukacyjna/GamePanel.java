/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WJP_GraEdukacyjna;

import javax.swing.JPanel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Color;
import java.text.DecimalFormat;



/**
 *
 * @author Lucek
 */
public class GamePanel extends JPanel{
    // szerokość pola graficznego
    public int sWidth;
    //wysokośc pola graficznego
    public int sHeight;
    //obiekt reprezentujący status gry
    public GameStatus gStatus;
    //wysokość paska menu
    public int barHeight;
    //czcionka stosowana w menu
    public Font menuFont;
    //czcionki stosowane w polu gry jako alert
    public Font alertFont;
    
     
    public GamePanel(int width, int height){
         gStatus=new GameStatus();
         gStatus.reset();
         menuFont = new Font("Dialog",Font.BOLD,36);
        alertFont=new Font("Dialog",Font.BOLD,92);
        
        this.sWidth=width;
        this.sHeight=height;
        barHeight=50;
        
        //c=Color.YELLOW;
        //x=512;
        //y=380;
        
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
              //czy wybrano rozpoczęcie nowego poziomu lub nowej gry
              if(me.getX()>500 && me.getX()<800 && me.getY()>(sHeight-barHeight)){
                  //Nowa gra
                  if(GameConst.pause){
                      GameConst.MoveMODE=1;
                      GameConst.end=false;
                      gStatus.reset();
                      GameConst.levelPause=false;
                      GameConst.bgImage = GameConst.loadImage("images/Islandia-A-beautiful-green-and-red-aurora-dancing-over-the-Jokulsarlon-lagoon-Iceland-shutterstock_241717330.jpg");
                      //restartGame();
                      repaint();
                  }else{
                      //Nowy poziom
                      if(GameConst.levelPause){
                          //Czy dostępny jest kolejny poziom
                          if (GameConst.MoveMODE<GameConst.NO_LEVELS){
                              GameConst.MoveMODE++;
                              gStatus.time+=GameConst.levelTime;
                              GameConst.levelPause=false;
                              GameConst.bgImage = GameConst.loadImage("images/Islandia-A-beautiful-green-and-red-aurora-dancing-over-the-Jokulsarlon-lagoon-Iceland-shutterstock_241717330.jpg");
                              gStatus.nextLevel();
                              //restartGame();
                          }else{
                              //koniec poziomĂłw = koniec gry
                              GameConst.end=true;
                              gStatus.time+=GameConst.levelTime;
                              GameConst.pause=true;
                          }
                          repaint();
    }
        }
              }}});}
    
    protected void paintComponent(Graphics gs){
        Graphics2D g=(Graphics2D)gs;
        //Ustaw tryb lepszej jakoĹ›ci grafiki (wygĹ‚adzanie/antyaliasing)
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // Narysuj tło
        g.drawImage(GameConst.bgImage, 0, 0, null);
        

        //Ustaw kolor dolnego paska Menu i narysuj pasek
        g.setColor(new Color(50,30,0));
        g.fillRect(0, sHeight-barHeight, sWidth, barHeight);
        //Ustaw kolor domyĹ›lny
        g.setColor(Color.white);
        //Ustaw czcionki do wypeĹ‚nienia paska Menu
        g.setFont(menuFont);
        
        //JeĹ›li juĹĽ wybrano Menu (czyli pausa) narysuj stosownÄ… wersjÄ™ paska Menu
        if(GameConst.pause){
            g.setColor(Color.red);
            g.drawString("KONIEC GRY!",10,sHeight-10);
            g.setColor(Color.white);
            g.drawString("O GRZE...",300, sHeight-10);
            g.drawString("NOWA GRA!",550, sHeight-10);
            if(GameConst.end){ //Czy wszystkie poziomy skoĹ„czone - koniec gry
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
            g.drawString("POZIOM:",10, sHeight-10);
            g.drawString("MENU",900, sHeight-10);    
            g.drawString(""+gStatus.level,200, sHeight-10);
            g.drawString("PUNKTY:",300, sHeight-10);
            // Czy ukoĹ„czono poziom - wskazano wszystkie obiekty pozciomu 
            if(gStatus.points==300){
                if(!GameConst.levelPause){
                    long stopTime = System.currentTimeMillis();
                    GameConst.levelTime=(stopTime-GameConst.startTime)/1000.0;
                    GameConst.levelPause=true;
                }
                g.setColor(Color.RED);
                g.drawString("GRASZ DALEJ?",500, sHeight-10);
                g.setFont(alertFont);
                DecimalFormat df = new DecimalFormat("#.##");
                g.drawString("WYGRANA:"+df.format(GameConst.levelTime)+"s",150, sHeight/2);
                g.setColor(Color.white);
                g.setFont(menuFont);
            //Jak nie zmieĹ„ punkty jeĹ›li stosowne
            }else
                g.drawString(""+gStatus.points,500, sHeight-10);
            
            //narysuj ikonkę z napisem Menu
            g.drawImage(GameConst.menuImage,sWidth-150,sHeight-barHeight-30,null);
        }

    }//
    
    
    
    
    
    }
    

