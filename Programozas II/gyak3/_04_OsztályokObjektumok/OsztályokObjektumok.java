package _04_OsztályokObjektumok;

public class OsztályokObjektumok {
    public static void main(String[] args) {
        int szám;
        String név;
        Állat csiga;

        // Emlékeztető: ez nem működik, mert kötelező inicializálni a változót, azaz kezdőértéket kell beállítani!
        //System.out.println(szám);

        szám = 100;
        név = "Dezső";
        csiga = new Állat(); // példányosítás -> konstruktor
        csiga.név = "Oszkár";
        csiga.tömeg = 20;

        Állat madár = new Állat();
        madár.név = név;
        madár.tömeg = szám * 2;
        //Állat.származásiHely = "Mars"; // csiga.származásiHely = "Mars" is szintaktikailag helyes, de nem javasolt osztályszintű változók esetén

        System.out.println(szám);
        System.out.println(név);
        System.out.println(csiga); // package.osztály@{objektumazonosító}
        System.out.println(madár); // package.osztály@{objektumazonosító}
        System.out.println(csiga == madár); // false

        Állat kutya = new Állat();

        csiga.eszik();
        madár.eszik(3 * szám + 1);

        // Ha a metódusnak van visszatérési értéke, azt is meghívhatjuk csak úgy
        kutya.részletek(); // nem kötelező változóba menteni a metódus eredményét

        String csigaRészletesLeírás = csiga.részletek();
        System.out.println(csigaRészletesLeírás);
        System.out.println(madár.részletek());
        System.out.println(kutya.részletek());

        System.out.println("Az állat neve " + csiga.név + ", ami " + csiga.tömeg + "g, származási helye: " + Állat.származásiHely);
        System.out.println("Az állat neve " + madár.név + ", ami " + madár.tömeg + "g, származási helye: " + Állat.származásiHely);
        System.out.println("Az állat neve " + kutya.név + ", ami " + kutya.tömeg + "g, származási helye: " + Állat.származásiHely);
    }
}