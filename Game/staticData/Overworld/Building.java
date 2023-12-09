package Game.StaticData.Overworld;

public class Building extends OverworldObject{
    private int spriteWidth;
    private int spriteHeight;

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