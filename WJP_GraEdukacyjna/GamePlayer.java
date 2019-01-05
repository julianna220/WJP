
package WJP_GraEdukacyjna;

import java.awt.Image;
import javax.swing.ImageIcon;

public class GamePlayer {
    
    private int  tileX, tileY;
    
    private Image player;
    
    public GamePlayer (){
        
        ImageIcon img = new ImageIcon ("C://Users//Lucek//Documents//NetBeansProjects//Maze//player.png");
        player = img.getImage();
 
        tileX = 1;
        tileY = 1;
    }
    
    public Image getPlayer(){
    return player;
    }

    
      public int getTileX(){
        return tileX;
    }
    
      
       public int getTileY(){
        return tileY;
    }
    public void move(int dx, int dy){
        
        
        tileX += dx;
        tileY += dy;
        
    }
    
    public void resetMovement (){
    
        tileX = 1;
        tileY = 1;
        
        
    }
}
