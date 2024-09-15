package _04_OsztályokObjektumok;

public class Main {
    /**
     * Objektumorientált programozás (Object oriented programming)
     * Objektum:
     * - tulajdonságok + viselkedés (példányváltozók + metódusok)
     * - megvalósítja az egységbezárást
     * - van identitása
     * Program: objektumok közötti interakció
     * Java: (nem tisztán) OOP nyelv
     * Osztály:
     * - "tervrajzok", az objektumok leírásai
     * - metódusok és adattagok formájában írják le az objektumot
     * - az osztály példányai az objektumok (példányosítás)
     */

    public static void main(String[] args) {
        int szám;
        String név;
        Állat csiga;

        //System.out.println(szám); // ez nem működik, mert kötelező inicializálni a változót, azaz kezdőértéket kell beállítani!

        szám = 100;
        név = "Dezső";
        //csiga = new Állat(); // példányosítás -> konstruktor
        csiga = new Állat("Oszkár", 20); // ha paraméteres konstruktort használunk
        //csiga.név = "Oszkár";
        //csiga.tömeg = 20;

        //Állat madár = new Állat();
        //Állat madár = new Állat(név); // ha paraméteres konstruktort használunk
        Állat madár = new Állat(név, szám * 2); // ha paraméteres konstruktort használunk
        //madár.név = név;
        //madár.tömeg = szám * 2;
        //csiga.származásiHely = "Mars"; // ez szintaktikailag helyes, viszont nem ajánlott! Hiszen osztályszintű változó próbálunk megváltoztatni egy példányon keresztül
        Állat.származásiHely = "Mars";

        System.out.println(szám);
        System.out.println(név);
        System.out.println(csiga); // package.osztály@{objektumazonosító}
        System.out.println(madár);
        System.out.println(csiga == madár);

        Állat kutya = new Állat(null);
        //kutya.tömeg = 2000;
        //kutya.név = null; // null: olyan referencia, amely nem mutat sehova

        csiga.eszik();
        madár.eszik(3 + szám);

        String csigaBemutatkozás = csiga.bemutatkozás() + "!";
        System.out.println(csigaBemutatkozás);
        System.out.println(madár.bemutatkozás());

        // Ha a metódusnak van visszatérési értéke, azt is meghívhatjuk csak úgy
        kutya.bemutatkozás(); // nem kötelező változóba menteni a metódus eredményét

        /*System.out.println(csiga.név + " az állat neve, ami " + csiga.tömeg + "g, származási helye a " + Állat.származásiHely);
        System.out.println(madár.név + " az állat neve, ami " + madár.tömeg + "g, származási helye a " + Állat.származásiHely);
        System.out.println(kutya.név + " az állat neve, ami " + kutya.tömeg + "g, származási helye a " + Állat.származásiHely);*/

        System.out.println("Állatok száma: " + Állat.állatokSzáma);
    }
}