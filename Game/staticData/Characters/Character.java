package Game.StaticData.Characters;

import Game.StaticData.Overworld.OverworldObject;

public class Character extends OverworldObject{
    protected String name;
    protected CharacterType type;

    public Character(String name, CharacterType type, int x, int y, int width, int height, String spritePath) {
        super(x, y, width, height, spritePath);
        this.name = name;
        this.type = type;
    }
}