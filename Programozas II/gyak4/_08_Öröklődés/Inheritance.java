package _08_Öröklődés;

/**
 *      super class
 *        /   \
 *       /     \
 *  subclass   subclass
 *
 *  polymorphism: "is a" relationship
 */

public class Inheritance {
    public static void main(String[] args) {
        /*Star sun = new Star();
        sun.setName("Sun");
        sun.setPhase("main sequence");*/
        Star sun = new Star("Sun", "main sequence");
        sun.setCoreTemperature(13_600_000);
        //System.out.println(sun.description());
        describeCelestialBody(sun); // Polimorfizmushoz példa: azért helyes, mert a sun-nak van getName metódusa, hiszen a CelestialBody-ból örökli

        Planet earth = new Planet("Earth", sun);
        /*Planet earth = new Planet();
        earth.setName("Earth");
        earth.setBelongsTo(sun);*/
        earth.setNumberOfMoons(1);
        earth.setLifePresent(true);
        //System.out.println(earth.description());
        describeCelestialBody(earth); // Polimorfizmushoz példa

        //GiantPlanet jupiter = new GiantPlanet();
        GiantPlanet jupiter = new GiantPlanet("Jupiter", sun, "gas giant"); // amikor van paraméteres konstruktor
        //jupiter.setName("Jupiter");
        jupiter.setType("gas giant");
        describeCelestialBody(jupiter); // Polimorfizmushoz példa

        // Polimorfizmus nem csak metódushívásnál működik, de működik változókra is
        //CelestialBody genericBody = new Star(); // ez az értékadás működik, mert létrehozunk egy Star objektumot, amely egy CelestialBody

        // earth -> lásd: 21. sor: Planet earth = new Planet(); a new Planet() dinamikus (futási időben ismert), a Planet pedig statikus (fordítási időben ismert)
        CelestialBody genericBody = earth; // ez is lehetséges, mert a Planet egy SolarBody, ami egy CelestialBody
        //CelestialBody genericBody = new Star(); // ez is lehetséges, mert a Star egy CelestialBody
        System.out.println(genericBody.description());

        // Polimorfizmus következménye: Ez nem lehetséges, mert csak olyan metódust hívhatunk meg, amely a CelestialBody rendelkezik
        // Azért kapunk hibát, mert a fordító azt nézi mi a tényleges (statikus) típusa, és a CelestialBody nem rendelkezik isLifePresent metódussal
        //genericBody.isLifePresent();

        // Típuskényszerítés
        Planet planet = (Planet) genericBody; // Minden Planet CelestialBody, de nem minden CelestialBody Planet
        System.out.println(planet.getName() + " has life: " + planet.isLifePresent());
    }

    // Polimorfizmushoz példa
    private static void describeCelestialBody(CelestialBody body) {
        //System.out.println(body.getName());
        System.out.println(body.description()); // Polimorfizmus következményének szimulálása
    }
}