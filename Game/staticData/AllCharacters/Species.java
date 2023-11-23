package Game.staticData.AllCharacters;

// import image module;

public class Species {

    // variables
    protected int id;
    protected String name;
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

    public Species(int id, String name, int baseHp, int baseAtk, int baseDef, int baseSpa, int baseSpd, int baseSpe) {
        this.id = id;
        this.name = name;
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
        this(self.getID(), self.getName(), self.getBaseHp(), self.getBaseAtk(), self.getBaseDef(), self.getBaseSpa(), self.getBaseSpd(), self.getBaseSpe());
    }
}