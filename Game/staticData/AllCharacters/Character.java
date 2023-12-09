package Game.StaticData.AllCharacters;


public class Character extends Collidable{
    protected String name;
    protected CharacterType type;

    public Character(String name, CharacterType type, int x, int y, int width, int height) {
        super(x, y, width, height); 
        this.name = name;
        this.type = type;
    }
}