package __Gyakorlat; // ezt módosítani kell, ha saját package-t használ, vagy pontosan ilyen nevű package létrehozása kötelező

public class HelloWorld {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello world!"); // sout + ENTER -> code snippet -> automatikusan létrehozza a kódsort
        //helloWorld(); // ahhoz, hogy működjön, vegye ki a kommentelést a helloWorld(); előtt

        int életkor; // változó deklaráció inicializáció nélkül
        //System.out.println(életkor); // ha a kommentelést kiveszi, akkor hiba lép fel, mert inicializáció szükséges ahhoz, hogy használhassuk

        életkor = 18; // változóhoz érték hozzáadása
        int újÉletkor = 25; // változó deklaráció inicializációval
        double lebegőpontosSzám = 150; // vagy 150.0, de ha csak 150-ként adjuk meg és a változó típusa double, akkor lebegőpontosként veszi
        System.out.println(lebegőpontosSzám);

        // Szöveg összefűzése változóértékkel -> + operátor (itt nem az összeadást jelenti)
        System.out.println("Lebegőpontos szám: " + lebegőpontosSzám);

        int életkor2 = életkor; // itt az életkor értéke átmásolódik az életkor2 változóba, tehát megnézi, hogy az életkor mely memóriacímet reprezentálja, ott milyen érték van eltárolva és azt az értéket átmásolja az életkor2 változóba
        System.out.println("életkor2: " + életkor2);
        életkor = 20;
        System.out.println("életkor2: " + életkor2); // az életkor2 értéke nem lesz 20, mert csak másolás történt, nincs

        char karakter1 = 'a';
        char karakter2 = 'b';
        System.out.println(karakter1 + karakter2); // azt várnánk, hogy ab, de nem mert ilyenkor a karakterek kódjai adódnak össze
        System.out.println("" + karakter1 + karakter2); // egy egyszerű megoldás: "", amely egy sztring, ehhez már hozzáfűzhetőek a karakterek

        // az int, double, float, boolean, char típusok primitívek
        // kivéve a String, mert - mint a nevéből is látszik (nagybetűvel kezdődik) - egy objektum
        String szöveg = "Ez egy szöveg"; // String:
        System.out.println("A szöveg második betűje: " + szöveg.charAt(1));
        System.out.println("\"\" egy üres string? " + "".isEmpty());
        System.out.println("A szöveg változó üres string? " + szöveg.isEmpty());
    }

    // speciális "Hello World" kiíratása
    public static void helloWorld() throws InterruptedException {
        String hw = "HELLO WORLD";
        int l = hw.length();
        StringBuilder output = new StringBuilder(" ".repeat(l));

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 255; j++) {
                output.setCharAt(i, (char) j);
                System.out.print("\r" + output);
                Thread.sleep(10);
                if (output.charAt(i) == hw.charAt(i)) {
                    break;
                }
            }
        }
        System.out.println(" ");
    }
}