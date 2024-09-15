package Filemanagement_Basic;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;
import java.util.StringJoiner;

public class FileWrite {
    public static void writeOddNumbersToFile(Set<Integer> numbers, String outputFileName) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFileName))) {
            StringJoiner joiner = new StringJoiner(",");
            /*for (Integer number : numbers) {
                if (number % 2 != 0) {
                    joiner.add(number.toString());
                }
            }*/
            numbers.stream().filter(number -> number % 2 != 0).map(Object::toString).forEach(joiner::add); // lambda kifejezés
            bufferedWriter.write(joiner.toString());
            System.out.println("Páratlan számok sikeresen kiírva a fájlba: " + outputFileName);
        } catch (IOException e) {
            System.out.println("Hiba a fájl írása közben: " + e.getMessage());
        }
    }
}