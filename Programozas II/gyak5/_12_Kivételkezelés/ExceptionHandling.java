package _12_Kivételkezelés;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandling {
    public static void main(String[] args) {
        /* tryCatchFinallyBlock */
        //tryCatchFinallyBlock();

        /* catchOrThrow */
        try {
            String text = catchOrThrow("README.md");
            System.out.println(text);
        } catch (FileNotFoundException e) {
            System.out.println("A megadott fájl nem létezik.");
        }
    }

    private static void tryCatchFinallyBlock() {
        Scanner input = new Scanner(System.in);
        do {
            try {
                System.out.print("Adjon meg egy számot: ");
                //int number = input.nextInt(); // itt keletkezhet kivétel - RuntimeException
                int number = Integer.parseInt(input.nextLine()); // do-while ciklus használatakor kell
                int result = 100 / number; // itt is keletkezhet kivétel - RuntimeException
                System.out.printf("100 / %d = %d%n", number, result);
                break;
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Nem számot adott meg.");
            } catch (ArithmeticException e) {
                System.out.println("0-val nem lehet osztani.");
                break;
            } /*catch (InputMismatchException | ArithmeticException e) { // vagy egyszerűen: RuntimeException e
                System.out.println("Valami baj történt.");
            }*/ /*finally { // akkor szükséges, ha nem do-while ciklust használunk
                System.out.println("Scanner lezárása.");
                input.close();
            }*/
        } while (true);
        input.close();
        System.out.println("Metódus vége.");
    }

    private static String catchOrThrow(String filename) throws FileNotFoundException {
        //FileReader reader = null; // ez akkor kell, ha a try blokkban kezeljük a new FileReader(filename)-t
        FileReader reader = new FileReader(filename); // ez akkor kell, ha nem akarjuk kezelni ezt a kivételt, de mivel ellenőrzött kivételt dobhat, így mindenképp jelezni kell az őt hívónak a throws kulcsszóval
        try {
            //reader = new FileReader(filename); // akkor nem kell ez, ha nem akarjuk kezelni, így kimozgatjuk a try blokkból
            StringWriter writer = new StringWriter();
            reader.transferTo(writer);
            return writer.toString();
        } /*catch (FileNotFoundException e) { // számít a sorrend: azaz először FileNotFoundException, majd csak utána lehet IOException, mert leszármazási viszonyban vannak
            System.out.println("A fájl nem létezik.");
            return null;
        }*/ catch (IOException e) {
            return "";
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ignored) {
                }
            }
        }
    }

    private static String tryWithResources(String filename) {
        try (FileReader reader = new FileReader(filename);
             StringWriter writer = new StringWriter()) {
            reader.transferTo(writer);
            return writer.toString();
        } catch (IOException e) {
            return "";
        } finally {
            System.out.println("Metódus vége.");
        }
    }
}