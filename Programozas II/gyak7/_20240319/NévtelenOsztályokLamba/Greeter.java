package _20240319.NévtelenOsztályokLamba;

// Java 8 óta: azok az interfészek, amelyeknek csak és kizárólag 1 (absztrakt) metódusa van, amit implementálni kell -> Funkcionális interfész
@FunctionalInterface
public interface Greeter {
    String greet(String name);
}