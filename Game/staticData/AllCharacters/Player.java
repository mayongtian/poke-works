package Game.staticData.AllCharacters;

import java.util.*;

import Game.staticData.*;

public class Player extends Character{
    private Pokemon[] party;
    private ArrayList<Item> bag;
    private int OverworldX;
    private int OverworldY;

    public Pokemon getPokemon(int index){
        return this.party[index];
    }

    public Item getItem(String name){
        for(Item i : bag) {
            if(i.getName().equals(name)){
                return i;
            }
        }
        return null;
    }

    public int getX(){
        return this.OverworldX;
    }

    public int getY(){
        return this.OverworldY;
    }

    public Player(String name, CharacterType type){
        super(name, type);
    }
}