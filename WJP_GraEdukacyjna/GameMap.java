/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WJP_GraEdukacyjna;

import java.awt.Image;
import java.io.File;
import java.util.*;
import javax.swing.ImageIcon;

/**
 *
 * @author Lucek
 */
public class GameMap {
    
    private Scanner m;
    private String Map[] = new String[14];
    
    private Image grass,
                  wall,
                  mapaszw,
                  mapaszw2;
    
    public GameMap(){
        
        ImageIcon img = new ImageIcon("C://Users//Lucek//Documents//NetBeansProjects//Maze//grass.png");
        grass = img.getImage();
        ImageIcon img2 = new ImageIcon("C://Users//Lucek//Documents//NetBeansProjects//Maze//wall.png");
        wall = img2.getImage();
        
        ImageIcon img3 = new ImageIcon("Images//mapa_szw.png");
        mapaszw = img3.getImage();
        
        ImageIcon img4 = new ImageIcon("Images//mapa_szw2.png");
        mapaszw2 = img4.getImage();
        
        openFile();
        readFile();
        closeFile();
    
    }
    
    public Image getGrass(){
        return grass;
    }
    
     public Image getWall(){
        return wall;
    }
     
     public Image getMapaszw(){
        return mapaszw;
    }
    
    public Image getMapaszw2(){
        return mapaszw2;
    }
     
    public String getMap(int x, int y){
        String index = Map[y].substring(x,x+1);
        return index;
}

    
    public void openFile(){
    
        try{
        m = new Scanner (new File("C://Users//Lucek//Documents//NetBeansProjects//Maze//Map.txt"));
        }catch(Exception e){
            System.out.println("error loading map");
        }
        
    }
    
    public void readFile(){
    while(m.hasNext())
        for(int i = 0; i < 14; i++){
            Map[i] = m.next();
        }
    }
    
    public void closeFile(){
         m.close();}
}
