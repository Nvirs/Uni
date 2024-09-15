package _15_Collections;

import java.util.HashMap;
import java.util.Map;

public class MapTelefonkonyv {
    public static void main(String[] args) {
        // Telefonkönyv létrehozása
        Map<String, String> telefonkonyv = new HashMap<>();

        // Név és telefonszám hozzáadása a telefonkönyvhöz
        telefonkonyv.put("John Doe", "123-456-789");
        telefonkonyv.put("Jane Doe", "987-654-321");
        telefonkonyv.put("Alice", "111-222-333");

        // Telefonkönyvben keresés név alapján
        String telefonszam = telefonkonyv.get("John Doe");
        System.out.println("John Doe telefonszáma: " + telefonszam);

        // Telefonkönyv méretének lekérdezése
        int meret = telefonkonyv.size();
        System.out.println("Telefonkönyv mérete: " + meret);

        // Telefonkönyv tartalmazza-e egy adott nevet
        boolean tartalmazNevet = telefonkonyv.containsKey("Jane Doe");
        System.out.println("Tartalmazza Jane Doe-t? " + (tartalmazNevet ? "Igen" : "Nem"));

        // Telefonkönyv tartalmazza-e egy adott telefonszámot
        boolean tartalmazSzamot = telefonkonyv.containsValue("111-222-333");
        System.out.println("Tartalmazza a 111-222-333 telefonszámot? " + (tartalmazSzamot ? "Igen": "Nem"));

        // Telefonkönyvben lévő összes név lekérdezése
        System.out.println("Telefonkönyvben lévő összes név:");
        for (String nev : telefonkonyv.keySet())
            System.out.println(nev);

        // Telefonkönyvben lévő összes telefonszám lekérdezése
        System.out.println("Telefonkönyvben lévő összes telefonszám:");
        for (String szam : telefonkonyv.values())
            System.out.println(szam);

        // Telefonkönyv bejárása kulcs-érték párok segítségével
        System.out.println("Telefonkönyv bejárása:");
        for (Map.Entry<String, String> bejegyzes : telefonkonyv.entrySet()) {
            System.out.println("Név: " + bejegyzes.getKey() + ", Telefonszám: " + bejegyzes.getValue());
        }

        // Név alapján történő törlés a telefonkönyvből
        telefonkonyv.remove("Alice");
        System.out.println("Alice-t eltávolítottuk a telefonkönyvből.");

        // Telefonkönyv kiürítése
        telefonkonyv.clear();
        System.out.println("A telefonkönyv kiürítve.");
    }
}