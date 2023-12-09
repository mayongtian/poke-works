package Game.StaticData.Overworld;


import Game.StaticData.WorldMap;
import Game.StaticData.AllCharacters.*;





public class Gate {
    private int x;
    private int y;
    private int width;
    private int height;
    
    private Location homeLocation;
    private int nextLocationID;
    private int nextX;
    private int nextY;

    // getters
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

    public int getNextLocation(){
        return this.nextLocationID;
    }
    
    public int getNextX(){
        return this.nextX;
    }

    public int getNextY(){
        return this.nextY;
    }

    // important methods

    public void travel(Player p) {
        p.setOverworldX(this.nextX);
        p.setOverworldY(this.nextY);
        WorldMap map = this.homeLocation.getMap();
       
       //List<Location> location_test_ls = new ArrayList

        map.setCurrentLocation(map.getLocations().get(this.nextLocationID -1));
    }   

    // constructors
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
