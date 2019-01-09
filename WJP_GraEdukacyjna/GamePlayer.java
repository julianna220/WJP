package WJP_GraEdukacyjna;

/**
 * Klasa odpowiedzialna za aktualną pozycje gracza
 * @author Julianna Wichowska
 */
public class GamePlayer {
    
    private int  currX, currY; //aktualne położenie gracza
    
    /**
     * Metoda zapisująca stan początkowy gracza
     */
    public GamePlayer (){
        currX = 1;
        currY = 1;
    }
    
    /**
     * Metoda zwracajaca aktualne położenie gracza w płaszczyźnie X
     * @return aktualne położenie gracza w płaszczyźnie X 
     */
      public int getTileX(){
        return currX;
    }
    
    /**
     * Metoda zwracajaca aktualne położenie gracza w płaszczyźnie Y
     * @return aktualne położenie gracza w płaszczyźnie Y
    */
       public int getTileY(){
        return currY;
    }
       
    /**
     * Metoda zmieniająca położenie gracza o wartość dx w płaszczyźnie X
     * i o wartość dy w płaszczyźnie Y
     * @param dx wartość o którą zostanie przemieszczony gracz względem osi X
     * @param dy wartość o którą zostanie przemieszczony gracz względem osi Y
     */
    public void move(int dx, int dy){
        currX += dx;
        currY += dy;    
    }
    
    /**
     * Metoda resetująca przemieszczenie gracza, ustawiająca jego położenie na stan początkowy 
     */
    public void resetMovement (){
        currX = 1;
        currY = 1;   
    }
}
