package Game.staticData.AllCharacters;

import Game.staticData.Map;
import java.util.*;

import javax.imageio.ImageIO;

import java.awt.Graphics;
import java.io.File;
import java.awt.Image;
import java.io.IOException;

import Game.staticData.*;

public class Player extends Character{
    private Pokemon[] party;
    private ArrayList<Item> bag;
    private int OverworldX;
    private int OverworldY;
    private Image sprite;
    private boolean movingLeft;
    private boolean movingRight;
    private boolean movingUp;
    private boolean movingDown;

    public Pokemon getPokemon(int index){
        return this.party[index];
    }

    public Item getItem(String name){
        for(Item i : bag) {
            if(i.getName().equals(name)){
                return i;
            }
        }
        return null;
    }

    public int getOverworldX(){
        return this.OverworldX;
    }

    public int getOverworldY(){
        return this.OverworldY;
    }

    public boolean getMovingUp(){
        return this.movingUp;
    }

    public boolean getMovingDown(){
        return this.movingDown;
    }

    public boolean getMovingLeft(){
        return this.movingLeft;
    }

    public boolean getMovingRight(){
        return this.movingRight;
    }

    public Image getSprite(){
        return this.sprite;
    }

    public void setOverworldX(int x){
        this.OverworldX = x;
    }

    public void setOverworldY(int y){
        this.OverworldY = y;
    }

    public void setMovingUp(boolean toggle){
        this.movingUp = toggle;
    }

    public void setMovingDown(boolean toggle){
        this.movingDown = toggle;
    }

    public void setMovingLeft(boolean toggle){
        this.movingLeft = toggle;
    }

    public void setMovingRight(boolean toggle){
        this.movingRight = toggle;
    }

    public void moveUp(Map m){
        if(m.y<0 && this.OverworldY == 360 - this.sprite.getHeight(null)/2){
            m.y+=5;
        }
        else if(this.OverworldY > 0 || this.OverworldY > this.sprite.getHeight(null)/2){
            this.OverworldY-=5;
        }
    }

    public void moveDown(Map m){
        if(m.y> -1 * (m.getCurrentLocation().map.getHeight(null) - 720) && this.OverworldY == 360){
            m.y-=5;
        }
        else if(this.OverworldY < 470 || this.OverworldY < this.sprite.getHeight(null)/2){
            this.OverworldY+=5;
        }
        
    }

    public void moveRight(Map m){
        if(m.x> -1 * (m.getCurrentLocation().map.getWidth(null) - 1280) && this.OverworldX == 640){
            m.x-=5;
        } 
        else if(this.OverworldX < 1030 || this.OverworldX < 640 - this.sprite.getWidth(null)/2){
            this.OverworldX+=5;
        }
    }

    public void moveLeft(Map m){
        if(m.x<0 && this.OverworldX == 640 - this.sprite.getWidth(null)/2){
            m.x+=5;
        }
        else if(this.OverworldX > 0 || this.OverworldX > 640 - this.sprite.getWidth(null)/2){
            this.OverworldX-=5;
        }
    }

    public void paint(Graphics g){
        g.drawImage(this.sprite, this.OverworldX, this.OverworldY, null);
    }

    public Player(String name, CharacterType type){
        super(name, type);
        try{
            File file = new File("Drawings/sinistea.jpg"); //load image into a File object
            Image image = ImageIO.read(file); //create Image object from File object
            this.sprite = image;
            System.out.println(image.getWidth(null));
            this.OverworldX = 640 - image.getWidth(null)/2;
            this.OverworldY = 360 - image.getHeight(null)/2;
        }
        catch(IOException e){
            e.printStackTrace();
        }
        
        
    }
}