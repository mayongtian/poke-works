package Game;
import java.util.ArrayList;
import java.awt.Image;

public class Location {
    public ArrayList<Gate> gates = new ArrayList<Gate>();
    public int id;
    public String name;
    public Image map;

    public ArrayList<Gate> getGates(){
        return gates;
    }

    public Location(int id, String name, Image map){
        this.map = map;
        this.name = name;
        this.id = id;
    }
}
