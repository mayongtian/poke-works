package Game.StaticData;

import Game.StaticData.Overworld.Location;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import Game.StaticData.Overworld.Building;
//import java.io.FileReader;
import java.util.Scanner;
import Game.StaticData.Overworld.Gate;

public class WorldMap {
    private ArrayList<Location> locations;
    private Location currentLocation;
    //private Image map;
    public int x;
    public int y;

    public ArrayList<Location> getLocations(){
        return this.locations;
    }

    public Location getCurrentLocation(){
        return this.currentLocation;
    }

    public void setCurrentLocation(Location location){
        this.currentLocation = location;
    }

    public void paint(Graphics g){
        g.drawImage(this.currentLocation.getMapImage(), this.x, this.y, null);
        for(Building b: this.currentLocation.getBuildings()){
            g.drawImage(b.getSprite(), this.x, this.y, null);
        }
        
    }

    public WorldMap(int x, int y){
        this.x = x;
        this.y = y;
        this.locations = new ArrayList<Location>(); 
        try{
            File file = new File("Game/Setup/Locations.txt");
            Scanner reader = new Scanner(file);
            String object;
            while(reader.hasNextLine()){
                object = reader.nextLine();
                String objectData[] = object.split(";");
                int id = Integer.parseInt(objectData[0]);
                String name = objectData[1];
                File imgFile = new File(objectData[2]);
                Image map = ImageIO.read(imgFile);
                locations.add(new Location(id, name, map));
            }
            reader.close();
            file = new File("Game/Setup/Gates.txt");
            reader = new Scanner(file);
            while(reader.hasNextLine()){
                object = reader.nextLine();
                String objectData[] = object.split(";");
                Location location = locations.get(Integer.parseInt(objectData[0]) - 1);
                ArrayList<Gate> gates = location.getGates();
                gates.add(new Gate(Integer.parseInt(objectData[1]), Integer.parseInt(objectData[2]), Integer.parseInt(objectData[3]), Integer.parseInt(objectData[4]), Integer.parseInt(objectData[5]), Integer.parseInt(objectData[6]), Integer.parseInt(objectData[7])));
            }
            reader.close();
            this.setCurrentLocation(locations.get(0));
            System.out.println(this.getCurrentLocation().getMapImage().getWidth(null));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}