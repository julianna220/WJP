/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WJP_GraEdukacyjna;

/**
 *
 * @author Lucek
 */
public class GameStatus {

    //liczba zgromadzonych punktów na danym poziomie
    public int points;
    //nuumer poziomu
    public int level;
    //czas gry na danym poziomie
    public double time;
    
    //zerowanie parametrów gry
    public void reset(){
        points=0;
        level=1;
        time=0.0;
    }
    
    //zerowanie punktów
    public void resetPoints(){
        points=0;
    }
    
    //zwiększenie poziomu
    public void nextLevel(){
        level++;
    }
    
}
