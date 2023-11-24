package Game.staticData.AllCharacters;

import java.awt.Graphics;
import java.awt.Image;


import Game.App;
import Game.staticData.*;

public class Pokemon extends Species {
    
    private int level;
    private boolean shiny;
    private int hpIV;
    private int atkIV;
    private int defIV;
    private int spaIV;
    private int spdIV;
    private int speIV;

    private int hpEV;
    private int atkEV;
    private int defEV;
    private int spaEV;
    private int spdEV;
    private int speEV;

    private Nature nature;


    /*
        HP = floor(0.01 x (2 x Base + IV + floor(0.25 x EV)) x Level) + Level + 10
        Other Stats = (floor(0.01 x (2 x Base + IV + floor(0.25 x EV)) x Level) + 5) x Nature
    */

    public boolean getShiny(){
        return this.shiny;
    }

    public int getHp() {
        return (int)(0.01 * (2 * this.baseHp + this.hpIV + (int)(0.25 * this.hpEV)) * this.level) + this.level + 10;
    }

    public int getAtk() {
        return (int)(((0.01 * (2 * this.baseAtk + this.atkIV + (int)(0.25 * this.atkEV)) * this.level) + 5) * this.nature.ATK);
    }
    
    public int getDef() {
        return this.baseDef * this.level + this.defIV + this.defEV/4;
    }

    public int getSpa() {
        return this.baseSpe * this.level + this.spaIV + this.spaEV/4;
    }

    public int getSpd() {
        return this.baseSpd * this.level + this.spdIV + this.spdEV/4;
    }
    
    public int getSpe() {
        return this.baseSpe * this.level + this.speIV + this.speEV/4;
    }

    public void paint(Graphics g, Image sprite, int x, int y){
        g.drawImage(sprite, x, y, null); //draw Image object on screen at coordinates (250,350)

    }

    public Pokemon(Species species, int level, boolean shiny) {
        super(species);
        this.level = level;
        this.shiny = shiny;
        this.hpIV = App.random.nextInt(31);
    }
}