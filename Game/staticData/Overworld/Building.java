package Game.StaticData.Overworld;

import java.awt.Polygon;
import java.util.ArrayList;

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

    public Building(int x, int y, int width, int height, int spriteWidth, int spriteHeight, String spritePath){
        super(x,y,width,height, spritePath);
        this.spriteWidth = spriteWidth;
        this.spriteHeight = spriteHeight;
    }
}