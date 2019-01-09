package WJP_GraEdukacyjna;

import java.awt.Toolkit;

/**
 * Główna klasa projektu
 * @author Julianna Wichowska
 */
public class WJP_GraEdukacyjna {


    public static void main(String[] args) {
       
        //Ustalenie rozmiaru okna gry
        int gameWidth = 1250;
        int gameHeight = 900;
        
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
