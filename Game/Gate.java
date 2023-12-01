package Game;

public class Gate {
    private int x;
    private int y;
    private int width;
    private int height;
    private int nextLocationID;
    private int nextX;
    private int nextY;
    
    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public int getWidth(){
        return this.width;
    }

    public int getHeight(){
       return this.height;
    }

    public int getNextLocationID(){
        return this.nextLocationID;
    }
    
    public int getNextX(){
        return nextX;
    }

    public int getNextY(){
        return nextY;
    }

    public Gate(int x, int y, int width, int height, int nextLocationID, int nextX, int nextY) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.nextLocationID = nextLocationID;
        this.nextX = nextX;
        this.nextY = nextY;
    }
}
