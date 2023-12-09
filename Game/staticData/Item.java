package Game.StaticData;

public class Item {
    private String name;
    private Passive passive;
    private Active active;

    public String getName() {
        return this.name;
    }

    public Item(String name, Passive passive, Active active) {
        this.name = name;
        this.passive = passive;
        this.active = active;
    }
}