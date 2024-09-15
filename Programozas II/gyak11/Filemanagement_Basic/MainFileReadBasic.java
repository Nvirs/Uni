package Filemanagement_Basic;

import org.javatuples.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

public class MainFileReadBasic {
    private static final String path = "./src/main/resources/"; // egy konstans, mely a fájl útvonalát definiálja

    public static void main(String[] args) {
        // Az 'input_01.txt' fájl beolvasása az általunk létrehozott metódussal
        Set<Integer> numbersFromFile = FileRead.displayNumbersFromFile(path + "input_01.txt");
        // Fájl tartalmának kiíratása
        System.out.print("Számok (v1.0): ");
        for (Integer number : numbersFromFile)
            System.out.print(number + " ");
        System.out.print("\nSzámok (v1.1): ");
        int numbersFromFileIndex = 0;
        for (Integer number : numbersFromFile)
            System.out.print(number + (numbersFromFileIndex++ < numbersFromFile.size() - 1 ? ", " : "."));
        // Fájl tartalmának kiíratása - lambda kifejezéssel
        System.out.print("\nSzámok (v2.0): ");
        numbersFromFile.forEach(x -> System.out.print(x + " "));
        System.out.print("\nSzámok (v2.1): ");
        System.out.println(numbersFromFile.stream().map(Object::toString).collect(Collectors.joining(", ")) + ".");

        System.out.println("============================");

        // Az 'input_02.txt' fájl beolvasása az általunk létrehozott metódussal
        try (BufferedReader bufferedReader = FileRead.openFile(path + "input_02.txt")) {
            // fájl beolvasása után a betűk számának meghatározása
            int characterCount = FileRead.countCharacters(bufferedReader);
            System.out.println("A betűk száma a fájlban: " + characterCount);
        } catch (IOException e) {
            System.out.println("Hiba történt a fájl olvasása során: " + e.getMessage());
        }

        System.out.println("============================");

        // Az 'input_02.txt' fájl beolvasása az általunk létrehozott metódussal
        try (BufferedReader bufferedReader = FileRead.openFile(path + "input_02.txt")) {
            // A másik, általunk létrehozott metódussal meghatározzuk a betűk számát és magukat a betűket megjelenítjük
            Pair<String, Integer> getCharAndCountChar = FileRead.getAndCountCharacters(bufferedReader, path + "output_02.txt");
            System.out.println("Betűk a fájlban: " + getCharAndCountChar.getValue0()); // getValue0: a Pair típusú objektum első eleme
            System.out.println("A betűk száma a fájlban: " + getCharAndCountChar.getValue1()); // getValue1: a Pair típusú objektum második eleme
        } catch (IOException e) {
            System.out.println("Hiba történt a fájl olvasása során: " + e.getMessage());
        }

        System.out.println("============================");

        // Fájlbaírás
        FileWrite.writeOddNumbersToFile(numbersFromFile, path + "output_01.txt");
    }
}