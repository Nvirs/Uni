package _20_Streams;

import java.util.Objects;
import java.util.Set;

public class Person {
    private final String name;
    private final Set<String> friends;

    public Person(String name, Set<String> friends) {
        this.name = name;
        this.friends = friends;
    }

    public String getName() {
        return name;
    }

    public Set<String> getFriends() {
        return friends;
    }

    // equals & hashCode: fontos szerepet játszanak az objektumok összehasonlításában és az adatszerkezetekben való tárolásuk optimalizálásában.
    /* Az equals() metódus két objektum egyenlőségét határozza meg.
    * Az equals() metódus akkor tér vissza true értékkel, ha a két objektum "egyenlő" a metódus definíciója szerint.
    * Például, a String osztály equals() metódusa akkor tér vissza true értékkel, ha a két string tartalma megegyezik.
    * */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(friends, person.friends);
    }

    /* A hashCode() metódus egy egész számot generál, amit hash kódnak nevezünk.
    * A hash kódokat általában hash alapú adatszerkezetek, mint például a HashMap és HashSet, használják az objektumok gyors elérésére.
    * A hashCode() metódusnak az a szabálya, hogy ha két objektum equals() szerint egyenlő, akkor a hashCode() metódusuknak ugyanazt az értéket kell visszaadnia.
    * */
    @Override
    public int hashCode() {
        return Objects.hash(name, friends);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", friends=" + friends +
                '}';
    }
}