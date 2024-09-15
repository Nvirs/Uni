package _08_Öröklődés;

public class Star extends CelestialBody {
    //private String name; // Ez nem felüldefiniálás; Ezt elfedésnek hívják
    private String phase;
    private double coreTemperature;

    /*public Star() {
        super("star");
    }

    public Star(String name) {
        //this.name = name; // ez nem működik, mert a name privát az ősosztályban
        super(name);
    }*/

    public Star() {
        this("star", "Default phase");
    }

    public Star(String name, String phase) {
        super(name);
        this.phase = phase;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public double getCoreTemperature() {
        return coreTemperature;
    }

    public void setCoreTemperature(double coreTemperature) {
        this.coreTemperature = coreTemperature;
    }

    /*public String description() {
        return "The " + getName() + " is a " + phase + " star.";
    }*/

    // Ősosztály metódusának meghívása
    public String description() {
        return super.description() + " is a " + phase + " star.";
    }

    // metódusok felüldefiniálásának szabályai - példa
    @Override // egy annotáció, mely jelzi, hogy ez a metódus felül lesz definiálva
    public void calculateVelocity() { // láthatóságot bővíteni szabad, szűkíteni nem lehet; típusnak meg kell egyeznie, objektumoknál más a helyzet

    }
}