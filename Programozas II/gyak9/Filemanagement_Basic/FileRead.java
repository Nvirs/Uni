package Filemanagement_Basic;

import org.javatuples.Pair;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;

public class FileRead {
    public static Set<Integer> displayNumbersFromFile(String fileName) {
        Set<Integer> numbers = new HashSet<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            // Fájl beolvasása után Set-be tárolni - klasszikus módszer
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] tokens = line.split(",");
                for (String token : tokens) {
                    int num = Integer.parseInt(token.trim());
                    numbers.add(num);
                }
            }

            // Fájl beolvasása után Set-be tárolni - lambda kifejezés
            /*bufferedReader.lines().flatMap(line -> Arrays.stream(line.split(",")))
                    .mapToInt(Integer::parseInt) // vagy mapToInt(adat -> Integer.parseInt(adat))
                    .forEach(numbers::add); // vagy forEach(x -> numbers.add(x))*/
        } catch (IOException e) {
            System.out.println("Hiba a fájl beolvasásakor: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Hibás adatformátum!");
        }

        return numbers;
    }

    /* Feladat: az input_02.txt fájl beolvasása, meghatározni a betűket és azok számát. */

    // Fájlbeolvasáshoz metódus
    public static BufferedReader openFile(String fileName) throws IOException {
        FileReader fileReader = new FileReader(fileName);
        return new BufferedReader(fileReader);
    }

    // Betűk számának meghatározása
    public static int countCharacters(BufferedReader bufferedReader) throws IOException {
        int characterCount = 0, currentChar;
        while ((currentChar = bufferedReader.read()) != -1)
            if (Character.isLetter((char) currentChar)) characterCount++;
        return characterCount;
    }

    // Betűk számának meghatározása és a betűk megjelenítése a fájlból
    // Két külön metódus szükséges, hasonló logikával -> felesleges két (azért nem teljesen) hasonló metódust létrehozni
    // Ha olyan metódust szeretnénk létrehozni, ahol két eredményt szeretnénk kapni -> érdemes a Pair objektumot alkalmazni
    // Pair: olyan osztály, mely két elemet kezel, melynek típusai bármi lehet (generikus)
    public static Pair<String, Integer> getAndCountCharacters(BufferedReader bufferedReader) throws IOException {
        int characterCount = 0, currentChar;
        /* String-ekhez léteznek összefűző technikák: StringBuilder és StringJoiner */
        //StringBuilder characters = new StringBuilder();
        StringJoiner joiner = new StringJoiner(",");

        while ((currentChar = bufferedReader.read()) != -1) {
            if (Character.isLetter((char) currentChar)) {
                // karakterek kiíratása StringBuilder használatával, vesszővel elválasztva
                /*if (!characters.isEmpty()) characters.append(',');
                characters.append((char) currentChar);*/

                // karakterek kiíratása StringJoiner használatával, vesszővel elválasztva
                joiner.add(String.valueOf((char) currentChar));
                characterCount++;
            }
        }

        //return new Pair<>(characters.toString(), characterCount);
        return new Pair<>(joiner.toString(), characterCount);
    }
}