package Game;
import Game.StaticData.WorldMap;
import Game.StaticData.AllCharacters.Collidable;
import Game.StaticData.Overworld.OverworldObject;

public interface Movable<T extends OverworldObject>{
    
    public void moveRight(WorldMap m);

    public void moveLeft(WorldMap m);

    public void moveUp(WorldMap m);

    public void moveDown(WorldMap m);
    
    public boolean inHitBox(Collidable m);

}