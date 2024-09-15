package _08_Öröklődés;

public class CelestialBody {
    private String name;

    public CelestialBody(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Polimorfizmus következménye: definiáljunk egy description metódust, amely már van a Planet és Star osztályokban
    public String description() {
        return getName();
    }
}