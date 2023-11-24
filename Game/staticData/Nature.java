package Game.staticData;

public enum Nature {
    HARDY(1, 1, 1, 1, 1), 
    LONELY(1.1F, 0.9F, 1,  1,  1), 
    ADAMANT(1.1F, 1, 0.9F,  1,  1), 
    NAUGHTY(1.1F, 1, 1,  0.9F,  1),
    BRAVE(1.1F, 1, 1,  1,  0.9F),

    BOLD(0.9F, 1.1F, 1,  1,  1),
    DOCILE(1, 1, 1, 1, 1),
    IMPISH(1, 1.1F, 0.9F,  1,  1),
    LAX(1, 1.1F, 1,  0.9F,  1),
    RELAXED(1, 1.1F, 1,  1,  0.9F),

    MODEST(0.9F, 1, 1.1F, 1, 1),
    MILD(1, 0.9F, 1.1F, 1, 1),
    BASHFUL(1, 1, 1, 1, 1),
    RASH(1, 1, 1.1F, 0.9F, 1),
    QUIET(1, 1, 1.1F, 1, 0.9F),
    
    CALM(0.9F, 1, 1, 1.1F, 1),
    GENTLE(1, 0.9F, 1, 1.1F, 1),
    CAREFUL(1, 1, 0.9F, 1.1F, 1),
    QUIRKY(1, 1, 1, 1, 1),
    SASSY(1, 1, 1, 1.1F, 0.9F),

    TIMID(0.9F, 1, 1, 1, 1.1F),
    HASTY(1, 0.9F, 1, 1, 1.1F),
    JOLLY(1, 1, 0.9F, 1, 1.1F),
    NAIVE(1, 1, 1, 0.9F, 1.1F),
    SERIOUS(1, 1, 1, 1, 1);


    public final float ATK;
    public final float DEF;
    public final float SPA;
    public final float SPD;
    public final float SPE;

    private Nature(float ATK, float DEF, float SPA, float SPD, float SPE){
        this.ATK = ATK;
        this.DEF = DEF;
        this.SPA = SPA;
        this.SPD = SPD;
        this.SPE = SPE;
    }
}
