package WJP_GraEdukacyjna;

/**
 * Klasa przechowywująca aktualny stan gry
 * @author Julianna Wichowska
 */
public class GameStatus {

    //liczba zgromadzonych punktów na danym poziomie
    public int points;
    //nuumer poziomu
    public int level;
    //czas gry na danym poziomie
    public double time;
    //czy wybrano poprawną odpowiedź
    public int levelWon = 0;
    //zaczęcie grę
    public boolean gameStarted = false;
    //ukazanie pomiaru czasu
    public boolean showTime = false;
    //ukazanie pytania 
    public boolean showGame = false;
    
    /**
    * Metoda serujaca parametry gry
    */
    public void reset(){
        points=0;
        level=1;
        time=0.0;
        GameConst.startTime=System.currentTimeMillis();
        GameConst.pause=false;
    }
    
}
