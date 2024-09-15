package _20240319.AbsztraktOsztályok;

public interface UserInterface {
    void displayMenu();
    void getUserInput();

    /* Alapértelmezett metódus - Java 8
    * Az alapértelmezett metódusokat arra tervezték, hogy egy alapvető implementációt biztosítsanak
    * az interfészben deklarált metódusokhoz, amelyet az implementáló osztályok felülírhatnak, ha szükséges.
    * */
    default void draw() {
        System.out.println("Drawing a shape...");
    }
}