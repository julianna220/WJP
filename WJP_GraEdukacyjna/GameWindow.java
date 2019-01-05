/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WJP_GraEdukacyjna;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.Toolkit;


/**
 *
 * @author Lucek
 */
public class GameWindow extends JFrame{
    
    public GameWindow (int width, int height, int x, int y){
        
        super();
        setSize(width, height); //ustawienie wymiarów okna
        setLocation(x,y); //ustawienie pozycji okna
        setResizable(false); //zablokowanie opcji zmiany rozmiaru okna
        setUndecorated(true); //ukrycie ramki i przycisków kontrolnych
        initGUI(width,height); // wywołanie metody budowy interfejsu
        setVisible(true); //wyświetlenie okna
        animationLoop(); //uruchomienie pętli animacji gry
         
    }
    
    
    private void initGUI(int width, int height){
        setLayout(new GridLayout(1,1)); // rozkład 
        GameConst.loadInitialImages(); //
        Toolkit tk = Toolkit.getDefaultToolkit();
        add(new GamePanel(width,height)); //dodanie nowego panelu gry zawierającego akcje
    }
    
    
    void animationLoop() {
        GameConst.startTime = System.currentTimeMillis(); //pobranie liczby milisekund
        long currTime = GameConst.startTime;
    
        while (currTime - GameConst.startTime < GameConst.GAME_TIME) {
          long elapsedTime = System.currentTimeMillis() - currTime;
          //liczenie czasu gry - mĹĽe siÄ™ przydaÄ‡ w ograniczeniach czasowycho 
          //w tej demonstracji nie wykorzystane
          currTime += elapsedTime;
          
          //odrysuj kolejny ekran gry (nowe pozycje obiektĂłw - symulacja ruchu)
          repaint();
          
          // przerwa w czasie
          try {
            Thread.sleep(80);
          } catch (InterruptedException ex) {System.out.println("WyjÄ…tek: "+ex);      }
        }//koniec while
    }//koniec animationLoop()
    }
