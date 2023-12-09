package Game.StaticData.Overworld;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;
import java.awt.Image;
import java.awt.Graphics;

public abstract class OverworldObject {
    private int x;
    private int y;
    private int width;
    private int height;
    private Image sprite;

    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    public int getWidth() {
        return this.width;
    }
    public int getHeight() {
        return this.height;
    }
    public Image getSprite() {
        return this.sprite;
    }

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }

    public void paint(Graphics g){
        g.drawImage(this.sprite, 0,0, null);
        System.out.println("ITS WORKING");
    }

    public OverworldObject(int x, int y, int width, int height, String spritePath) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        try{
            File file = new File(spritePath);
            this.sprite = ImageIO.read(file);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}