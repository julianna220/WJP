package WJP_GraEdukacyjna;

import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import javax.swing.ImageIcon;

/**
 * Klasa w której następuje odczyt plików tekstowych generujących labirynt oraz zasobów graficznyh tworzących labirynt
 * @author Julianna Wichowska
 */
public final class GameMap {
    
    private Scanner m; //obiekt do odebrania danych z pliku tekstowego
    private final String Map[] = new String[19]; //tabela służąca do zapisu danych z pliku tekstowego

    //zasobry graficzne labiryntu: track - trasa, wall - ściana, goal - meta
    private final Image track1, 
                        track2,
                        track3,
                        wall1,
                        wall2,
                        wall3,
                        goal;
    
    /**
     * Ładowanie zasobów graficznych labiryntu,inicjowanie odczytu plików tekstowych na podstawie których bazuje labirynt
     */
    
    public GameMap(){
        
        ImageIcon img = new ImageIcon("Images//track1.png");
        track1 = img.getImage();
        
        ImageIcon img2 = new ImageIcon("Images//track2.png");
        track2 = img2.getImage();
        
        ImageIcon img3 = new ImageIcon("Images//track3.png");
        track3 = img3.getImage();
        
        ImageIcon img4 = new ImageIcon("Images//wall1.png");
        wall1 = img4.getImage();
        
        ImageIcon img5 = new ImageIcon("Images//wall2.png");
        wall2 = img5.getImage();
        
        ImageIcon img6 = new ImageIcon("Images//wall3.png");
        wall3 = img6.getImage();
        
        ImageIcon img7 = new ImageIcon("Images//goal.png");
        goal = img7.getImage();
      
        openFile();
        readFile();
        closeFile();
        
    }
    
    
    /**
     * Metoda zwracająca obraz trasy, w zależności od aktualnego poziomu
     * @return zdjęcie trasy labiryntu
     */
     public Image getTrack(){
         if (GameConst.level == 1){
                return track1;
        }
         
        if (GameConst.level == 2){
                return track2;
        }
        else 
                return track3;
    }
     
     
     /**
      * Metoda zwracająca obraz ściany, w zależności od aktualnego poziomu
      * @return obraz ściany labiryntu
      */
     public Image getWall(){
         if (GameConst.level == 1){
                return wall1;
    }
        if (GameConst.level == 2){
                return wall2;
        }
        else 
                return wall3;
  
    }
     
    /**
     * Metoda zwracająca obraz mety
     * @return obra mety labiryntu
     */
    public Image getGoal(){
        return goal;
    }
     
    /**
     * Metoda otwierajaca plik tekstowy zawierający labirynt dla aktualnego poziomu
     */
    public void openFile(){
        try{
            switch (GameConst.level) {
                case 1:
                    m=new Scanner (new File("Maze/Map.txt"));
                    break;
                case 2:
                    m=new Scanner (new File("Maze/Map2.txt"));
                    break;
                case 3:
                    m=new Scanner (new File("Maze/Map3.txt"));
                    break;
            }
        }
    catch(FileNotFoundException e){
            System.out.println("Błąd");
        }    
    }
    
    /**
     * Metoda odczytująca plik tekstowy
     */
    public void readFile(){
    while(m.hasNext())
        for(int i = 0; i < 19; i++){
            Map[i] = m.next();
        }
    }
    
    /**
     * Metoda zamykająca plik tekstowy 
     */
    public void closeFile(){
         m.close();
    }
    
    /**
     * Metoda zwracajaca zawartośc komórki tabeli Map[] o parametrach x i y
     * @param x parametr tabeli 
     * @param y parametr tabeli
     * @return zawartośc komórki w danym polu Tabeli
     */
    public String getMap(int x, int y){
        String index = Map[y].substring(x,x+1);
        return index;
    }
       
}