package _03_Konverzió;

public class Conversion_bovites {
    public static void main(String[] args) {
        /* Típuskonverzió - bővítés -> nem a változót bővítjük, hanem a változóhoz tartozó értéket */
        byte bájt = 5;
        short rövid = bájt;
        int egész = rövid;
        long hosszúEgész = egész;
        float valós = hosszúEgész;
        double hosszúValós = valós;

        hosszúEgész = 15;
        hosszúValós = 15.0;
        //valós = 15.0; // Visszafelé nem működik a típuskonverzió bővítés

        // a fordító néha "csal"
        // mivel az 5 egy egész literál, és az 5-ös érték belefér egy bíte típusba, így a fordító a háttérben elvégzi a konverziót, tehát nem int-ként, hanem bíte-ként kezeli
        // valós számoknál ez nem működik!
        bájt = 5;
        //bájt = egész; // ez már nem működik
        bájt = 1 + 1;

        // Kifejezések típusa
        long a = 125 + 201; // int - int = int, majd bővítés long-ra
        float b = 5 + 9; // int + int = int, majd bővítés float-ra
        int c = bájt * rövid; // mindkét operandust int-re bővítjük, majd int * int
        long c2 = hosszúEgész * bájt; // bájtot bővítjük long-ra, majd long * long
        double d = 3.14f / egész; // egész bővítése double-re, majd osztás
        //byte x = bájt + bájt; // mivel az összeadás az egy egész összeadás, így a két bájtot int-re bővítjük és az összeadás eredménye is int lesz

        // számít a kiértékelési sorrend
        // az eredmény nem 6.3, hanem 5.8 lesz!
        // -> oka:
        //   * először az osztást végezzük el (mert az osztás művelet precedenciája magasabb az összeadásnál),
        //     és mivel a két operandus egész, így egészosztást lesz végrehajtva, az eredménye is egész lesz
        //   * utána azt látjuk, hogy van egy egész szám és egy double szám, tehát akkor egy double összeadás hajtódik végre,
        //     tehát az egészet konvertáljuk át double-re, azaz 2 -> 2.0 ... 2.0 + 3.8 = 5.8, ami rossz!
        double f = 5 / 2 + 3.8;
        double f2 = 5 / 2.0 + 3.8; // lehetséges megoldás

        System.out.println(f);
        System.out.println(f2);
    }
}