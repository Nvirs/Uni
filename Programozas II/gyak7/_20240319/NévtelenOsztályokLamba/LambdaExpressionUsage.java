package _20240319.NévtelenOsztályokLamba;

import java.util.Comparator;
import java.util.List;

import static _20240319.NévtelenOsztályokLamba.AnonymousExamples.createPeople;

public class LambdaExpressionUsage {
    public static void main(String[] args) {
        // simple lambda
        Greeter informalGreeter = name -> "Szia " + name;

        // lambda with multiline block
        Greeter screamer = name -> {
            StringBuilder sb = new StringBuilder(name.toUpperCase());
            for (int i = 1; i < sb.length(); i += 2) {
                char c = sb.charAt(i);
                sb.setCharAt(i, Character.toLowerCase(c));
            }
            return "Hello " + sb;
        };

        // A lambda kifejezés definiálásakor a blokkjában lévő rész nem fut le (ténylegesen csak a viselkedést írja le)...
        // ... mindaddig, amíg a lambda-n a greet metódus nincs meghívva
        System.out.println(screamer.greet("Zolika"));

        // empty parameter list + void
        Runnable doSomething = () -> System.out.println("Just do it!");
        doSomething.run();

        // multiple input parameters
        List<Person> people = createPeople();
        Comparator<? super Person> ageComparator = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return Integer.compare(o1.getAge(), o2.getAge());
            }
        };
        Comparator<Person> ageComparator2 = (o1, o2) -> Integer.compare(o1.getAge(), o2.getAge());
        people.sort(ageComparator2);
        System.out.println(people);

        // static method reference
        //Greeter warm = (name) -> screamer(name);
        // Metódus referencia szerinti megadás (metódus direkt hivatkozása)
        // mivel a screamer statikus, ilyen módon is hivatkozhatunk a metódusra -> "::": metódus-referencia operátora
        // Attól függetlenül, hogy a Greeter interfésznek semmi köze nincs a screamer metódushoz,
        // használható a referenciaoperátor, mert egyezik a szignatúra
        // A referenciaoperátor is egy lambda, csak máshogy néz ki
        Greeter warm = LambdaExpressionUsage::screamer;
        //LambdaExpressionUsage.screamer(name);
        System.out.println(warm.greet("Gábor"));

        // instance method reference
        WhoAreYou asker = new WhoAreYou();
        //Greeter asking = name -> asker.whoAreYou(name);
        Greeter asking = asker::whoAreYou;
        System.out.println(asking.greet("Gábor"));

        // lambda parameter name clash
        String name = "Ákos";
        Greeter hiGreeter = subject -> "Hi " + subject; // itt a subject helyett nem lehet name, mert ütközik a lokális változó nevével (62. sor)

        // effective final local variables
        /*
        * A Java lehetővé teszi a metódusreferenciák használatát olyan objektumokra, amelyek nem effective finalok.
        * Ez azért lehetséges, mert a metódusreferencia maga a hivatkozás a metódusra, és nem tartalmazza az objektumot, amelyre hivatkozik.
        * Amikor a metódusreferenciát használjuk, a hivatkozott metódust hívjuk meg a megadott objektumon,
        * de maga a referenciát tartalmazó változó értéke nem változik, és nem kerül közvetlenül hozzá az objektum.
        * Az asker::whoAreYou esetében a :: operátor a whoAreYou metódus referenciáját hozza létre az asker objektumon.
        * Itt az asker objektumot nem használjuk közvetlenül a lambda kifejezésben, így nem szükséges, hogy final vagy effectively final legyen.
        * Az a -> asker.whoAreYou(a) esetében viszont közvetlenül használjuk az asker objektumot a lambda kifejezésben.
        * Itt az asker objektumnak final vagy effectively final-nak kell lennie, hogy a lambda kifejezés használhassa.
        * Ha az asker objektum értéke megváltozik (például null-ra állítjuk), akkor az már nem lesz effectively final, és ez hibát okoz.
        * */
        //Greeter asking2 = a -> asker.whoAreYou(a);
        //asker = null;
    }

    private static String screamer(String name) {
        StringBuilder sb = new StringBuilder(name.toUpperCase());
        for (int i = 1; i < sb.length(); i += 2) {
            char c = sb.charAt(i);
            sb.setCharAt(i, Character.toLowerCase(c));
        }
        return "Hello " + sb;
    }
}