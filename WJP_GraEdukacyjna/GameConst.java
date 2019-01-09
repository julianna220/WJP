package WJP_GraEdukacyjna;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * Klasa zwierająca parametry gry. Odczytuje bądź zapisuje parametry takie jak zasoby graficzne do gry. 
 * @author Julianna Wichowska
 */
public class GameConst {
    
    //obraz tła na poziomie pierwszym
    public static Image Background1;
    //obraz tła na poziomie drugim
    public static Image Background2;
    //obraz tła na poziomie trzecim
    public static Image Background3;
    //obraz tła na zakończenie gry
    public static Image Background4;
    //obraz ikony kursora na poziomie pierwszym
    public static Image cursorImage1;
     //obraz ikony kursora na poziomie drugim
    public static Image cursorImage2;
     //obraz ikony kursora na poziomie trzecim
    public static Image cursorImage3;
    //obraz ikony gracza
    public static Image player;
    //obraz kraju na poziomie pierwszym
    public static Image Switzerland;
    //obraz kraju na poziomie drugim
    public static Image Iceland;
    //obraz kraju na poziomie trzecim
    public static Image Albania; 
    //zmiana stanu gry
    public static boolean pause=false;
    //zmiana stanu gry, czy wybrano menu
    public static boolean levelPause=false;
    //początkowy czas gry
    public static long startTime;
    //czas ukonczenia poziomu
    public static double levelTime;
    //liczba poziomow gry
    public final static long NO_LEVELS=3;
    //aktualny poziom gry
    public static int level=1;
    //ukonczenie gry
    public static boolean end=false;
    //rozmiary pola
    public static int gWidth=1280;
    public static int gHeight=1024;
    
    //Tablica przechowywująca pytania i odpowiedzi dla poziomu pierwszego
    public static String[][] QuestionsSwitzerland = new String[3][4];
    //Tablica przechowywująca pytania i odpowiedzi dla poziomu drugiego
    public static String[][] QuestionsIceland = new String[3][4];
    //Tablica przechowywująca pytania i odpowiedzi dla poziomu trzeciego
    public static String[][] QuestionsAlbania = new String[3][4];
    
    
    /**
     * Metoda ładująca pytania i odpoiwiedzi do tablic odpowiadających danemu poziomowi
     */
    
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
    
    
    
    QuestionsIceland[0][0] = "Populacja Islandii wynosi tyle samo co liczba ludności";
    QuestionsIceland[1][0] = "Jak inaczej jest określana Islandia?";
    QuestionsIceland[2][0] = "Ile miast znajduje się w Islandii?";

    QuestionsIceland[0][1] = "Gdańsk";
    QuestionsIceland[0][2] = "Lublin";
    QuestionsIceland[0][3] = "Wrocław";
  
    QuestionsIceland[1][1] = "Wyspa mrozu";
    QuestionsIceland[1][2] = "Wyspa lodu i ognia";
    QuestionsIceland[1][3] = "Samotna Wyspa";
    
    QuestionsIceland[2][1] = "90";
    QuestionsIceland[2][2] = "30";
    QuestionsIceland[2][3] = "150";
    
    
    
    QuestionsAlbania[0][0] = "Co jest stolicą Albanii?";
    QuestionsAlbania[1][0] = "Który z podanych krajów nie graniczy z Albanią?";
    QuestionsAlbania[2][0] = "Jaka jest waluta w Albanii?";

    QuestionsAlbania[0][1] = "Tirana";
    QuestionsAlbania[0][2] = "Podgornica";
    QuestionsAlbania[0][3] = "Belgrad";
  
    QuestionsAlbania[1][1] = "Chorwacja";
    QuestionsAlbania[1][2] = "Grecja";
    QuestionsAlbania[1][3] = "Macedonia";
    
    QuestionsAlbania[2][1] = "Lek albański";
    QuestionsAlbania[2][2] = "Dinar albański";
    QuestionsAlbania[2][3] = "Kuna";
    
    }
    
    /**
     * 
     * Metoda ładująca początkowe zasoby gry
     * 
     **/
    
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
        Background4 = loadImage ("Images//Background4.jpg");
        player = loadImage ("Images//player.png");
    }
    
    /**
     * Metoda pobierania obiektu klasy Image na podstawie ścieżki
     * dostępu podanej jako String
     * @param fileName nazwa pliku
     * @return zdjęcie
    */
    public static Image loadImage(String fileName) {
        return new ImageIcon(fileName).getImage();
    }
}

