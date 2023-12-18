package Game.StaticData.Overworld;

import java.awt.Polygon;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;
import java.awt.Image;
import java.awt.Color;
import java.awt.Graphics;

public class Building extends OverworldObject{
    private int spriteWidth;
    private int spriteHeight;
    private ArrayList<Polygon> im; // for the sprite; not sure what to do witht eh name rn

    public int getSpriteWidth(){
        return this.spriteWidth;
    }

    public int getSpriteHeight(){
        return this.spriteHeight;
    }

    // special getters for the floor hitbox
    public int getFloorHeight() {
        return this.y + this.spriteHeight - this.height;
    }

    /**
     * draws the hitboxes only 
     */
    @Deprecated
    public void paintTest(Graphics g, int relativeX, int relativeY){
        g.setColor(Color.RED);
        g.drawRect(relativeX + x, relativeY + y + spriteHeight - height, width, height);
    }

    public Building(int x, int y, int width, int height, int spriteWidth, int spriteHeight, String spritePath){
        super(x,y,width,height, spritePath);
        this.spriteWidth = spriteWidth;
        this.spriteHeight = spriteHeight;
    }
}