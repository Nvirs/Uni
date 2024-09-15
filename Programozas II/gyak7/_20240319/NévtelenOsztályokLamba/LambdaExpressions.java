package _20240319.NévtelenOsztályokLamba;

import java.util.List;

public class LambdaExpressions {
    public static void main(String[] args) {
        List<String> names = List.of("Anna", "Kati", "Gyuri");
        Greeter formalGreeter = new Greeter() {
            @Override
            public String greet(String name) {
                return "Üdvözöllek " + name + "!";
            }
        };

        // "->": lambda operátor --> szerepe az, hogy elválassza a formális paramétereket ténylegesen az implementációtól
        //Greeter informalGreeter = (String name) -> "Szia " + name; // nincs is szükség a String típusra a name előtt, mert ki lehet olvasni a Greeter interfészből!
        Greeter informalGreeter = name -> "Szia " + name;

        greetPeople(names, formalGreeter);
        greetPeople(names, informalGreeter);
        greetPeople(names, name -> "Szia " + name); // funkcionalitást tudunk átadni paraméterként
        greetPeople(names, name -> "Hello " + name + "!"); // funkcionalitást tudunk átadni paraméterként (a metódus törzsét, ha úgy tetszik)
    }

    private static void greetPeople(List<String> names, Greeter greeter) {
        for (String name : names) {
            System.out.println(greeter.greet(name));
        }
        System.out.println();
    }
}