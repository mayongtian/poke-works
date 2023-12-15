package Game.StaticData.Overworld;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;
import java.awt.Image;
import java.awt.Graphics;

public abstract class OverworldObject {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected Image sprite;

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

    public void paint(Graphics g, int relativeX, int relativeY) {
        g.drawImage(this.sprite, relativeX + x, relativeY + y, null);
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