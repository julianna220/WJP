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
    public final static long NO_LEVELS=3;
    //obraz tła
    public static Image Background1;
    public static Image Background2;
    public static Image Background3;
    //obraz menu
    public static Image menuImage;
    //obraz ikony kursora
    public static Image cursorImage1;
    public static Image cursorImage2;
    public static Image cursorImage3;
    public static Image Switzerland;
    public static Image Iceland;
    public static Image Albania;
    
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
    //czy kliknęto opis gry
    public static boolean instruction = false;
    //rozmiary pola
    public static int gWidth=1280;
    public static int gHeight=1024;

    public static String[][] QuestionsSwitzerland = new String[3][4];
    public static String[][] QuestionsIceland = new String[3][4];
    public static String[][] QuestionsAlbania = new String[3][4];
    
    static public void loadTables(){
        
    QuestionsSwitzerland[0][0] = "Z iloma krajami graniczy Szwajcaria?";
    QuestionsSwitzerland[1][0] = "Z jakim państwem kraj ten ma najdłuższą granicę?";
    QuestionsSwitzerland[2][0] = "Co jest popularną szwajcarską potrawą?";

    QuestionsSwitzerland[0][1] = "3";
    QuestionsSwitzerland[0][2] = "4";
    QuestionsSwitzerland[0][3] = "5";
  
    QuestionsSwitzerland[1][1] = "Francja";
    QuestionsSwitzerland[1][2] = "Niemcy";
    QuestionsSwitzerland[1][3] = "Włochy";
    
    QuestionsSwitzerland[2][1] = "Placek lotaryński ";
    QuestionsSwitzerland[2][2] = "Wołowina po burgundzku";
    QuestionsSwitzerland[2][3] = "Fondue";
    
    
    
    QuestionsIceland[0][0] = "Populacja Islandii wynosi prawie tyle samo co liczba ludności";
    QuestionsIceland[1][0] = "Jak inaczej jest określana Islandia?";
    QuestionsIceland[2][0] = "Ile miast znajduje się w Islandii?";

    QuestionsIceland[0][1] = "Lublin";
    QuestionsIceland[0][2] = "Gdańsk";
    QuestionsIceland[0][3] = "Wrocław";
  
    QuestionsIceland[1][1] = "Wyspa lodu i ognia";
    QuestionsIceland[1][2] = "Wyspa Mrozu";
    QuestionsIceland[1][3] = "Samotna Wyspa";
    
    QuestionsIceland[2][1] = "30";
    QuestionsIceland[2][2] = "90";
    QuestionsIceland[2][3] = "150";
    
    
    
    QuestionsAlbania[0][0] = "Co jest stolicą Albanii?";
    QuestionsAlbania[1][0] = "Który z podanych krajów nie graniczy z Albanią?";
    QuestionsAlbania[2][0] = "Jaka jest waluta w Albanii?";

    QuestionsAlbania[0][1] = "Podgorica";
    QuestionsAlbania[0][2] = "Tirana";
    QuestionsAlbania[0][3] = "Belgrad";
  
    QuestionsAlbania[1][1] = "Grecja";
    QuestionsAlbania[1][2] = "Chorwacja";
    QuestionsAlbania[1][3] = "Macedonia";
    
    QuestionsAlbania[2][1] = "Dinar albański";
    QuestionsAlbania[2][2] = "Lek albański";
    QuestionsAlbania[2][3] = "Kuna";
    
    }
    //ladowanie zasobow gry
    public static void loadInitialImages(){
        Background1 = loadImage("Images/Background1.jpg");
        Background2 = loadImage("Images/Background2.jpg");
        Background3 = loadImage("Images/Background3.jpg");
        cursorImage1=loadImage("Images/Flag_of_Switzerland.png");
        cursorImage2=loadImage("Images/Flag_of_Iceland.png");
        cursorImage3=loadImage("Images/Flag_of_Albania.png");
        Switzerland = loadImage("Images//Switzerland_in_Europe.png");
        Iceland = loadImage("Images//Iceland_in_Europe.png");
        Albania = loadImage ("Images//Albania_in_Europe.png");
    }
    

    
    public static Image loadImage(String fileName) {
        return new ImageIcon(fileName).getImage();
    }
}

