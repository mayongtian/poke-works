package Game.staticData.AllCharacters;

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

    public void moveUp(){
        this.OverworldY-=3;
    }

    public void moveDown(){
        this.OverworldY+=3;
    }

    public void moveRight(){
        this.OverworldX+=3;
    }

    public void moveLeft(){
        this.OverworldX-=3;
    }

    public void paint(Graphics g){
        g.drawImage(this.sprite, this.OverworldX, this.OverworldY, null);
    }

    public Player(String name, CharacterType type){
        super(name, type);
        this.OverworldX = 515;
        this.OverworldY = 235;
        try{
            File file = new File("Drawings/sinistea.jpg"); //load image into a File object
            Image image = ImageIO.read(file); //create Image object from File object
            this.sprite = image;
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}