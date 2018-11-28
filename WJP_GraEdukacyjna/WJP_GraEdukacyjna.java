/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WJP_GraEdukacyjna;
import java.awt.Toolkit;

/**
 *
 * @author Lucek
 */
public class WJP_GraEdukacyjna {


    public static void main(String[] args) {
       
        //Ustalenie rozmiaru gry
        int gameWidth = 1280;
        int gameHeight = 1024;
        
        //Pobieranie rozmiaru gry
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        
        //obliczanie wspolrzednych noraznika, aby pole gry znajdowalo sie na srodku
        int xCenter = (screenWidth  - gameWidth)/2;
        int yCenter = (screenHeight  - gameHeight)/2;
        
        
        //tworzenie obiektu klasy GameWindow - konstruktor wywoła dalsze akcje
        GameWindow gw = new GameWindow(gameWidth, gameHeight, xCenter, yCenter);
     
    }
    
}
