package _08_Öröklődés;

public class GiantPlanet extends SolarBody {
    private String type;

    public GiantPlanet(String name, Star belongsTo, String type) {
        super(name, belongsTo);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}