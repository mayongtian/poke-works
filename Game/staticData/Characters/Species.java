package Game.StaticData.Characters;

import java.awt.Image;
// import image module;

public class Species {

    // variables
    protected int id;
    protected String name;
    protected Image sprite;
    // image icon

    protected int baseHp;
    protected int baseAtk;
    protected int baseDef;
    protected int baseSpa;
    protected int baseSpd;
    protected int baseSpe;
    
    public int getID(){
        return this.id;
    }

    public String getName(){    
        return this.name;
    }

    public Image getSprite(){
        return this.sprite;
    }

    public int getBaseHp(){
        return this.baseHp;
    }

    public int getBaseAtk(){
        return this.baseAtk;
    }
    
    public int getBaseDef(){
        return this.baseDef;
    }

    public int getBaseSpa(){
        return this.baseSpa;
    }

    public int getBaseSpd(){
        return this.baseSpd;
    }
    
    public int getBaseSpe(){
        return this.baseSpe;
    }

    public Species(int id, String name, Image sprite , int baseHp, int baseAtk, int baseDef, int baseSpa, int baseSpd, int baseSpe) {
        this.id = id;
        this.name = name;
        this.sprite = sprite;
        this.baseHp = baseHp;
        this.baseAtk = baseAtk;
        this.baseDef = baseDef;
        this.baseSpa = baseSpa;
        this.baseSpd = baseSpd;
        this.baseSpe = baseSpe;
    }

    /**
     * Species constructor completely for use as a super for Pokemon
     */
    public Species(Species self) {
        this(self.getID(), self.getName(), self.getSprite(), self.getBaseHp(), self.getBaseAtk(), self.getBaseDef(), self.getBaseSpa(), self.getBaseSpd(), self.getBaseSpe());
    }
}