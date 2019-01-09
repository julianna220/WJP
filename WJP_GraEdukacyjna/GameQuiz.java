package WJP_GraEdukacyjna;

import java.util.Random;

/**
 * Klasa losujaca pytania do quizu 
 * @author Julianna Wichowska
 */
public class GameQuiz {
    
    //Tablica przechowywująca losowo ułożone pytania i odpowiedzi dla poziomu pierwszego   
    public static String[][] QuestionsS = new String[3][4]; 
    //Tablica przechowywująca losowo ułożone pytania i odpowiedzi dla poziomu drugiego
    public static String[][] QuestionsI = new String[3][4]; 
    //Tablica przechowywująca losowo ułożone pytania i odpowiedzi dla poziomu trzeciego
    public static String[][] QuestionsA = new String[3][4]; 

    /**
     * Metoda losowo przydzielająca pytania z pierwotnej tabeli z pytaniami i odpowiedziami
     * do nowej, której zawartość będzie wyświetlana w quizie
     */
    public static void QuestionsAnswers(){

        Random r = new Random(); //tworzenie obiektu generatora pseudolosowego

        int nr1 = r.nextInt(3); //przydzielenie losowej liczby z zakresu 0-2 do zmiennej nr1
        int nr2 = r.nextInt(3); //przydzielenie losowej liczby z zakresu 0-2 do zmiennej nr2

        while (nr1 == nr2){ //sprawdzenie czy zmienne nr1 i nr2 są sobie równe
            nr2 = r.nextInt(3); //ponowne przydzielenie losowej liczby z zakresu 0-2 do zmiennej nr2
        } 

        int nr3 = r.nextInt(3); //przydzielenie losowej liczby z zakresu 0-2 do zmiennej nr3

        while ( (nr1 == nr3)|| (nr2 == nr3) ){ //sprawdzenie czy zmienne nr1, nr2 i nr3 są sobie równe
            nr3 = r.nextInt(3); //ponowne przydzielenie losowej liczby z zakresu 0-2 do zmiennej nr3
        }

        //przydzielenie pytań i odpowiedzi dla poziomu pierwszego z pierwotnych tabel do nowowych

        for (int i=0; i < 1; i++){
            for(int j=0; j<=3;j++)
                QuestionsS[nr1][j] = GameConst.QuestionsSwitzerland[0][j];
        }

        for (int a=0; a < 1; a++){
            for(int b=0; b<=3;b++)
                QuestionsS[nr2][b] = GameConst.QuestionsSwitzerland[1][b];
        }

        for (int g=0; g < 1; g++){
            for(int h=0; h<=3;h++)
                QuestionsS[nr3][h] = GameConst.QuestionsSwitzerland[2][h];        
        }

        //przydzielenie pytań i odpowiedzi dla poziomu drugiego z pierwotnych tabel do nowowych  

        for (int i=0; i < 1; i++){
            for(int j=0; j<=3;j++) 
                QuestionsI[nr1][j] = GameConst.QuestionsIceland[0][j];
        }

        for (int a=0; a < 1; a++){
            for(int b=0; b<=3;b++)  
                QuestionsI[nr2][b] = GameConst.QuestionsIceland[1][b];
        }

        for (int g=0; g < 1; g++){
            for(int h=0; h<=3;h++)  
                QuestionsI[nr3][h] = GameConst.QuestionsIceland[2][h];
        }

        //przydzielenie pytań i odpowiedzi dla poziomu trzeciego z pierwotnych tabel do nowowych

        for (int i=0; i < 1; i++){
            for(int j=0; j<=3;j++)  
                QuestionsA[nr1][j] = GameConst.QuestionsAlbania[0][j];
        }

        for (int a=0; a < 1; a++){
            for(int b=0; b<=3;b++)
                QuestionsA[nr2][b] = GameConst.QuestionsAlbania[1][b];
        }

        for (int g=0; g < 1; g++){
            for(int h=0; h<=3;h++)
                QuestionsA[nr3][h] = GameConst.QuestionsAlbania[2][h];
        }
    }
}