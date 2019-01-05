/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WJP_GraEdukacyjna;

import java.awt.Graphics;
import java.awt.Graphics2D;
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
    private String Map[] = new String[19];

    
    private Image grass,
                  wall,
                  mapaszw,
                  mapaszw2,
                  meta;
    
    public GameMap(){
        
        ImageIcon img = new ImageIcon("Images//grass.png");
        grass = img.getImage();
        
        ImageIcon img2 = new ImageIcon("Images//wall.png");
        wall = img2.getImage();
        
        ImageIcon img5 = new ImageIcon("Images//meta.png");
        meta = img5.getImage();
      
        openFile(GameConst.MoveMODE);
        readFile();
        closeFile();
        
    }
    
    public Image getGrass(){
        return grass;
    }
    
     public Image getWall(){
        return wall;
    }
     
    
    public Image getMeta(){
        return meta;
    }
     
    
    public void openFile(int poziom){
        try{
            switch (GameConst.MoveMODE) {
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
    catch(Exception e){
            System.out.println("Błąd");
        }    
    }
    
    public void readFile(){
    while(m.hasNext())
        for(int i = 0; i < 19; i++){
            Map[i] = m.next();
        }
    }
    
    public void closeFile(){
         m.close();}
    
    
    public String getMap(int x, int y){
        String index = Map[y].substring(x,x+1);
        return index;
}
    

    
}