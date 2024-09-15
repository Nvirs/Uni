package _08_Öröklődés;

public class Planet extends SolarBody {
    private boolean lifePresent;

    public Planet(String name, Star belongsTo) {
        super(name, belongsTo);
    }

    public boolean isLifePresent() {
        return lifePresent;
    }

    public void setLifePresent(boolean lifePresent) {
        this.lifePresent = lifePresent;
    }

    /*public String description() {
        return "The " + getName() + " is a planet, belongs to " + getBelongsTo().getName();
    }*/

    // Ősosztály metódusának meghívása
    public String description() {
        return super.description() + " is a planet, belongs to " + getBelongsTo().getName();
    }
}