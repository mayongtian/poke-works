package Game.StaticData.Characters;
import Game.StaticData.WorldMap;
import Game.StaticData.Overworld.*;
import java.util.*;

import javax.imageio.ImageIO;

import java.awt.Graphics;
import java.awt.Image;

import Game.StaticData.*;

public class Player extends Character{
    private Pokemon[] party;
    private ArrayList<Item> bag;
    private int OverworldX;
    private int OverworldY;
    private int width;
    private int height;
    private boolean movingLeft;
    private boolean movingRight;
    private boolean movingUp;
    private boolean movingDown;
    private final int speed = 5;
    public static final int BUFFER = 30;

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

    public void setWidth(int width){
        this.width = width;
    }

    public void setHeight(int height){
        this.height = height;
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

    public void moveUp(Location location){
        for (Building b : location.getBuildings()) {
            if(this.getOverworldX() + this.getSprite().getWidth(null) >= b.getX() + location.getX() && this.OverworldY >= b.getY() + location.getY() && this.OverworldY <= b.getY() + b.getHeight()){
                return;
            }
        }
        location.setY(location.getY() + this.speed);
    }

    public void moveDown(Location location){
        for (Building b : location.getBuildings()) {
            if (b.getY() + b.getSpriteHeight() - b.getHeight() + location.getY() <= this.OverworldY + this.height) {
                return;
            }
        }
        location.setY(location.getY() - this.speed);
    }

    public void moveRight(Location location){
        for(Building b : location.getBuildings()){
            if(this.OverworldX + this.width >= b.getX() + location.getX() && this.OverworldY + this.height - Player.BUFFER >= b.getY() + location.getY() && this.OverworldY + this.height - Player.BUFFER <= b.getY() + b.getHeight()){
                return;
            }
        }
        location.setX(location.getX() - speed);
    }

    public void moveLeft(Location location){
        for(Building b : location.getBuildings()){
            if(this.OverworldX <= b.getX() + location.getX() + b.getWidth() && this.OverworldY + this.height - Player.BUFFER >= b.getY() + location.getY() && this.OverworldY + this.height - Player.BUFFER <= b.getY() + b.getHeight()){
                return;
            }
        }
        location.setX(location.getX() + speed);
    }

    public void paint(Graphics g){
        g.drawImage(this.sprite, this.OverworldX, this.OverworldY, null);
    }

    public Player(String name, CharacterType type, int OverworldX, int OverworldY, int width, int height, String spritePath){
        super(name, type, OverworldX, OverworldY, width, height, spritePath);
        this.OverworldX = 640 - this.sprite.getWidth(null)/2;
        this.OverworldY = 360 - this.sprite.getHeight(null)/2;
        this.setWidth(this.sprite.getWidth(null));
        this.setHeight(this.sprite.getHeight(null));
    }
}