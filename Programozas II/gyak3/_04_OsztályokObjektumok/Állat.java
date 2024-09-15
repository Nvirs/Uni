package _04_OsztályokObjektumok;

public class Állat {
    static String származásiHely = "Föld"; // statikus: állandó -> az adott osztályra vonatkozó tulajdonság (osztályváltozó)

    static int állatokSzáma;

    String név; // példányváltozó
    int tömeg;

    /* változók alapértelmezett kezdő értékei:
     * Objektum -> null
     * egész -> 0
     * valós -> 0.0
     * logikai -> false
     * char -> '\u0000'
     * */

    // konstruktor létrehozása explicit módon
    public Állat() {
    }

    // példányszintű metódusok
    void eszik() { // void: olyan metódus, amelynek nincsen visszatérési értéke; bármit csinál, csak "mellékhatása" van
        tömeg = tömeg + 1;
        //return; // void típusú metódusokhoz is írhatunk return-t, de felesleges
    }

    // metódus túlterhelés (method overload)
    void eszik(int növekmény) {
        tömeg = tömeg + növekmény;
    }

    // ez nem jó, mert már definiálva van egy olyan metódus ('eszik'), amelynek paramétere egy egész típusú változó
    /*boolean eszik(int valami) {
        return false;
    }*/

    // ez már jó, mert 1-nél több paraméterrel rendelkezik
    boolean eszik(int valami, String v) {
        return false;
    }

    String részletek() {
        return "Az állat neve " +név + ", ami " + tömeg + "g, származási helye: " + származásiHely;
    }

    // osztályszintű metódusok
    static void állatokSzámánakNövelése() {
        //tömeg++; // ez nem lehetséges, mert a 'tömeg' nem statikus, hanem egy példányváltozó, ahhoz szükség van egy példányra
        állatokSzáma++;
    }
}