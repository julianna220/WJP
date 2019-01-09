package WJP_GraEdukacyjna;

import javax.swing.JFrame;
import java.awt.Toolkit;

/**
 * Główne okno gry
 * @author Julianna Wichowska
 */

public class GameWindow extends JFrame{
    
    /**
     * Główny konstruktor klasy, ustawienie parametrów i zainicjalizowanie budowy interfejsu gry
     * @param width szerokość okna
     * @param height wysokość okna
     * @param x pozycja z lewego górnego arożnika gry
     * @param y pozycja y lewego górnego narożnika okna
     */
    
    public GameWindow (int width, int height, int x, int y){
        
        super(); //wywołanie konstruktora klasy nadrzędnej
        setSize(width, height); //ustawienie rozmiarów okna
        setLocation(x,y); //ustawienie pozycji okna
        setResizable(false); //zablokowanie opcji zmiany rozmiaru okna
        setUndecorated(true); //ukrycie ramki i przycisków kontrolnych
        initGUI(width,height); //wywołanie metody budowy interfejsu
        setVisible(true); //wyświetlenie okna
        animationLoop(); //uruchomienie pętli animacji gry
         
    }
    
    /**
     * Tworzenie interfejsu gry
     * @param width szerokośc okna
     * @param height wysokość okna
     */
    
    private void initGUI(int width, int height){
        GameConst.loadInitialImages(); //załadowanie parametrów i zasobów oczątkoweych gry
        add(new GameInstruction(width,height)); //dodanie nowego panelu gry zawierającego instrukcje
        add(new GamePanel(width,height)); //dodanie nowego panelu gry zawierającego akcje
    }
    
    /**
     * Główna pętla gry
     */
    
    void animationLoop() {
        while (true) {
          //odrysowanie nowego ekranu gry
          repaint();
          // przerwa w czasie
          try {
            Thread.sleep(80);
          } catch (InterruptedException ex) {System.out.println("Wyjątek: "+ex);      }
        }
    }
}
