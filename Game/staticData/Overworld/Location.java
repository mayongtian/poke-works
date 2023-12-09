package Game.StaticData.Overworld;

import java.util.ArrayList;
import java.awt.Image;
import Game.StaticData.WorldMap;

public class Location {
    private ArrayList<Gate> gates = new ArrayList<Gate>();
    private ArrayList<Building> buildings = new ArrayList<Building>();
    private int id;
    private String name;
    private Image localMap;
    private WorldMap world;

    public ArrayList<Gate> getGates(){
        return gates;
    }

    public ArrayList<Building> getBuildings(){
        return buildings;
    }

    public WorldMap getMap() {
        return this.world;
    }

    public void addBuilding(Building b){
        this.buildings.add(b);
    }

    public Location(int id, String name, Image localMap){
        this.localMap = localMap;
        this.name = name;
        this.id = id;
    }

    public Image getMapImage(){return localMap;}


}
