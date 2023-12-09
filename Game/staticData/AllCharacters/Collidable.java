package Game.StaticData.AllCharacters;

public class Collidable {
    private int x;
    private int y;
    private int width;
    private int height;



    public boolean inHitBox(Collidable m){
        if(m.getX() + m.getWidth() >= this.x && m.getX() <= this.x + this.width && m.getY() >= this.y && m.getY() >= this.y && m.getY() <= this.y + this.width){
            return true;
        }
        return false;
    }

    public void collide(Collidable c) {
        
    }


    public int getX(){return this.x;}
    public int getY(){return this.y;}
    public int getWidth(){return this.width;}
    public int getHeight(){return this.height;}

    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public void setWidth(int width){
        this.width = width;
    }
    public void setHeight(int height){
        this.height = height;
    }

    public void collide(){
        
    }

    public Collidable(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
}

