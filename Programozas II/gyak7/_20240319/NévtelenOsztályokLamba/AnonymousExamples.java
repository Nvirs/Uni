package _20240319.NévtelenOsztályokLamba;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AnonymousExamples {
    public static void main(String[] args) {
        List<Person> people = createPeople();

        // Névtelen osztály: itt helyben legyártunk egy implementációt
        // Ez az operáció, amit visszaad, az egy névtelen osztály
        // Azért névtelen osztály, mert nem hoztunk létre külön fájlt és adtunk meg nevet, hanem a Java fordító ad neki nevet
        Comparator<? super Person> ageComparator = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return Integer.compare(o1.getAge(), o2.getAge());
            }
        };
        people.sort(ageComparator);
        System.out.println(people);

        // Capturing - változó-elfogás (lokális változóra hivatkozhatunk névtelen osztályon belül)
        // eredetileg final-nek kell lennie (Java 8 előtt): final String prefix = "Hello "; ...
        // Java 8-tól: nem kell final-nak lennie --> effective final: egyszer kap értéket és soha nem változik
        String prefix = "Hello "; // effective final
        Person myPerson = new Person("Anonymous", 0) {
            @Override
            public String toString() {
                return prefix + getName().toUpperCase();
            }
        };
        //prefix = "valami"; // emiatt a myPerson-ben nem hivatkozhatunk a prefix-re, mert nem lesz final vagy effective final

        System.out.println(myPerson);
        System.out.println(myPerson.getClass().getName()); // _17_NévtelenOsztályok.AnonymousExamples$2, ahol $2, hogy egy második névtelen osztályt hoztunk létre
    }

    public static List<Person> createPeople() {
        Person kati = Person.person("Kati", 12);
        Person peti = Person.person("Peti", 31);
        Person laci = Person.person("Laci", 33);
        Person dani = Person.person("Dani", 17);
        Person zoli = Person.person("Zoli", 38);

        List<Person> people = new ArrayList<>();

        people.add(kati);
        people.add(peti);
        people.add(laci);
        people.add(dani);
        people.add(zoli);

        return people;
    }
}