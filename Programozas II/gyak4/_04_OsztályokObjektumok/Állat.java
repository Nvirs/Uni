package _04_OsztályokObjektumok;

public class Állat {
    static String származásiHely = "Föld"; // statikus: állandó -> az adott osztályra vonatkozó tulajdonság (osztályváltozó)
    static int állatokSzáma;

    public String név; // példányváltozó
    protected int tömeg;
    double sebesség;

    private boolean jóllakott;

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

    /*Állat(String aNév) {
        név = aNév;
    }*/

    // másik konstruktor meghívása egy konstruktorba
    public Állat(String aNév) {
        this(aNév, 0); // this csak is az első helyen állhat!
        System.out.println("Egy paraméteres konstruktor");
    }

    public Állat(String aNév, int aTömeg) {
        név = aNév;
        tömeg = aTömeg;
        állatokSzámánakNövelése(); // meghívható metódus is
        System.out.println("Állat létrehozva.");
    }

    // példányszintű metódusok
    /*void eszik() { // void: olyan metódus, amelynek nincsen visszatérési értéke; bármit csinál, csak "mellékhatása" van
        tömeg = tömeg + 1;
        //return; // void típusú metódusokhoz is írhatunk return-t, de felesleges
    }*/

    // átírhatjuk úgy is, hogy meghívjuk a paraméterrel rendelkező metódust
    void eszik() {
        //tömeg = tömeg + 1;
        eszik(1);
    }

    // metódus túlterhelés (method overload)
    void eszik(int növekmény) {
        tömeg = tömeg + növekmény;
        if (növekmény > tömeg * 0.1) {
            jóllakott = true;
        }
    }

    // ez nem jó, mert már definiálva van egy olyan metódus ('eszik'), amelynek paramétere egy egész típusú változó
    /*boolean eszik(int valami) {
        return false;
    }*/

    // ez már jó, mert 1-nél több paraméterrel rendelkezik
    /*boolean eszik(int valami, String v) {
        return false;
    }*/

    String bemutatkozás() {
        return "Az állat neve " + név + ", ami " + tömeg + "g, származási helye: " + származásiHely;
    }

    // osztályszintű metódusok
    private static void állatokSzámánakNövelése() {
        //tömeg++; // ez nem lehetséges, mert a 'tömeg' nem statikus, hanem egy példányváltozó, ahhoz szükség van egy példányra
        állatokSzáma++;
    }
}