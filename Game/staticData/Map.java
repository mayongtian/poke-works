package Game.staticData;

import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;


public class Map {
    private Image map;
    public int x;
    public int y;


    public void paint(Graphics g){
        g.drawImage(map, x, y, null);
    }

    public Map(Image map, int x, int y){
        this.x = x;
        this.y = y;
        try{
            File file = new File("Drawings/IMG_3046.jpg"); //load image into a File object
            Image image = ImageIO.read(file); //create Image object from File object
            this.map = image;
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
