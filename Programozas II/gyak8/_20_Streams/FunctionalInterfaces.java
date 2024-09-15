package _20_Streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.Stream;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        // Consumer - Egy műveletet képvisel, amely egy bemeneti argumentumot fogad és nem ad vissza eredményt
        /* A Consumer interfésznek két metódusa van:
         *   ** accept(T t): Ez a metódus egy értéket fogad és végrehajtja a műveletet a megadott argumentumon.
         *   ** andThen(Consumer<? super T> after): Ez a metódus egy összetett Consumer-t ad vissza,
         *      amelyben a paraméterként megadott Consumer a jelenlegi Consumer után hajtódik végre
         * */
        List<String> names = Arrays.asList("Anna", "Béla", "Cecília");
        Consumer<String> printName = new Consumer<String>() {
            @Override
            public void accept(String name) {
                System.out.println(name);
            }
        };
        names.forEach(printName);

        // Supplier - Egy műveletet képvisel, amely nem fogad bemeneti argumentumot, de előállít egy értéket
        // A Supplier interfésznek csak egy metódusa van, a get(), amely nem fogad bemeneti argumentumot, de előállít egy értéket
        Supplier<Double> randomSupplier = new Supplier<Double>() {
            @Override
            public Double get() {
                return Math.random();
            }
        };
        Stream<Double> randomStream = Stream.generate(randomSupplier);
        randomStream.limit(5).forEach(x -> System.out.println(x));

        // Function - Egy műveletet képvisel, amely egy argumentumot fogad és egy eredményt ad vissza
        // A Function interfésznek csak egy metódusa van, az apply(), amely egy argumentumot fogad és egy eredményt ad vissza
        Function<Integer, Integer> multiplyByTwo = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer number) {
                return number * 2;
            }
        };
        System.out.println(multiplyByTwo.apply(2));
        System.out.println(multiplyByTwo.apply(3));

        // Predicate - Egy műveletet képvisel, amely egy argumentumot fogad és egy boolean értéket ad vissza
        // A Predicate interfésznek csak egy metódusa van, a test(), amely egy argumentumot fogad és egy boolean értéket ad vissza
        Predicate<Integer> isEven = new Predicate<Integer>() {
            @Override
            public boolean test(Integer number) {
                return number % 2 == 0;
            }
        };
        System.out.println(isEven.test(2));  // true
        System.out.println(isEven.test(3));  // false
    }
}