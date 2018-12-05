/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WJP_GraEdukacyjna;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Lucek
 */
public class GameConst {
    
    //dopuszczalny czas gry
    public static long GAME_TIME=Long.MAX_VALUE;
    //liczba poziomow gry
    public final static long NO_LEVELS=2;
    //obraz tła
    public static Image bgImage;
    //obraz menu
    public static Image menuImage;
    //obraz ikony kursora
    public static Image cursorImage;
    //zmiana stanu gry
    public static boolean pause=false;
    //zmiana stanu gry, czy wybrano menu
    public static boolean levelPause=false;
    //początkowy czas gry
    public static long startTime;
    //czas ukonczenia poziomu
    public static double levelTime;
    //aktualny poziom gry
    public static int MoveMODE=1;
    //ukonczenie gry
    public static boolean end=false;
    //rozmiary pola
    public static int gWidth=1280;
    public static int gHeight=1024;
    
    
    //ladowanie zasobow gry
    public static void loadInitialImages(){
        bgImage = loadImage("Images/objazdówka_szwajcaria_ogromne_piękno_w_miniaturze_zurych_chur_st._moritz_bernina_express_tirano_funclub-2-2.jpg");
        menuImage=loadImage("");
        cursorImage=loadImage("Images/Flag_of_Switzerland_within_2to3.png");
    }
    
    public static Image loadImage(String fileName) {
        return new ImageIcon(fileName).getImage();
    }
}

