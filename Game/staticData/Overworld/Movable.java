package Game.StaticData.Overworld;
import Game.StaticData.WorldMap;

public interface Movable<T extends OverworldObject>{
    
    public void moveRight(WorldMap m);

    public void moveLeft(WorldMap m);

    public void moveUp(WorldMap m);

    public void moveDown(WorldMap m);
    
    public boolean inHitBox(OverworldObject m);

}