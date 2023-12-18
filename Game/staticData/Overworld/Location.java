package Game.StaticData.Overworld;

import java.util.ArrayList;
import java.awt.Image;
import Game.StaticData.WorldMap;
import Game.StaticData.Characters.Player;
import java.awt.Graphics;

public class Location {
    private ArrayList<Gate> gates = new ArrayList<Gate>();
    private ArrayList<Building> buildings = new ArrayList<Building>();
    private int id;
    private String name; 
    private Image localMap;
    private WorldMap world;
    private int x;
    private int y;

    public ArrayList<Gate> getGates(){
        return gates;
    }

    public ArrayList<Building> getBuildings(){
        return buildings;
    }

    public WorldMap getMap() {
        return this.world;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }

    public void addBuilding(Building b){
        this.buildings.add(b);
    }

    public void paint(Graphics g){
        g.drawImage(localMap, x, y, null);
        for(Building b: this.buildings){
            b.paint(g, this.x, this.y);
        }
    }

    @Deprecated
    public void paintTest(Graphics g){
        g.drawImage(localMap, x, y, null);
        for(Building b: this.buildings){
            b.paintTest(g,this.x, this.y);
        }
    }

    public Location(int id, String name, Image localMap){ 
        this.localMap = localMap;
        this.name = name;
        this.id = id;
        this.x = 0;
        this.y = 0;
    }

    public Image getMapImage(){return localMap;}
}
