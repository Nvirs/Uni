package __Gyakorlat;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Tombok {
    public static void main(String[] args) {
        int[] tömb = new int[5]; // üres tömb deklarálása; primitív tömb -> primitív típusokat tartalmaz
        // üres tömb deklarálása, melynek mérete egy konstans egész típusú változó
        /*final int tömbMéret = 5; // konstans érték definiálása
        int[] tömb2 = new int[tömbMéret];*/
        System.out.println("Az int[] egy objektumtípust reprezentál? " + (tömb instanceof Object));
        System.out.println("Üres tömb mérete: " + tömb.length);
        System.out.println(tömb); // [I@27d6c5e0 -> a tömb objektumának azonosítója ("[I": int típusú tömb; "@{érték}": az objektum hash kódja -> hexadecimális érték az objektum memóriacímének egy részletét jelenti)

        double[] lTömb = new double[10];
        System.out.println(lTömb); // [D@4f3f5b24 -> a tömb objektumának azonosítója ("[D": double típusú tömb; "@{érték}": az objektum hash kódja -> hexadecimális érték az objektum memóriacímének egy részletét jelenti)

        // tömb inicializálása értékekkel
        tömb = new int[]{3, 8, 6, 4, 5, 9};
        System.out.println("A tömb mérete: " + tömb.length);

        // tömb elemeinek egy lehetséges kiíratási módja
        System.out.println("Tömb elemei: " + Arrays.toString(tömb)); // tomb.toString() nem jó, mert csak a memóriacímet alakítja át szöveges formátummá. Ehelyett "be kell csomagolni" az Arrays objektumba és annak toString()-jét kell használni

        // tömb elemeinek kiíratása ciklussal
        System.out.print("Tömb elemei (v1): ");
        for (int i = 0; i < tömb.length; i++) {
            System.out.print(tömb[i] + " ");
        }

        System.out.print("\nTömb elemei (v2): ");
        int tömbIndex = 0;
        while (tömbIndex < tömb.length) {
            //System.out.print(tomb[tombIndex] + " ");
            //tombIndex++;
            System.out.print(tömb[tömbIndex++] + " ");
        }

        System.out.print("\nTömb elemei (v3): ");
        tömbIndex = 0;
        do {
            System.out.print(tömb[tömbIndex++] + " ");
        } while (tömbIndex < tömb.length);

        System.out.print("\nTömb elemei (v4): ");
        for (int elemek : tömb) {
            System.out.print(elemek + " ");
        }

        // Rendezés - buborékrendezés
        System.out.println("\nTömb elemei rendezés után: " + Arrays.toString(buborékrendezés(tömb)));

        // Rendezés - minimumkiválasztásos rendezés
        minimumkiválasztásosRendezés(tömb);
        System.out.println("Tömb elemei rendezés után: " + Arrays.toString(tömb));

        // Rendezés - sort metódussal
        Arrays.sort(tömb);
        System.out.println("Tömb elemei rendezés után: " + Arrays.toString(tömb));

        // Legnagyobb elem megkeresése
        int legnagyobb = tömb[0]; // Kezdetben a legnagyobb elem a tömb első eleme

        for (int i = 1; i < tömb.length; i++) {
            if (tömb[i] > legnagyobb) {
                legnagyobb = tömb[i];
            }
        }

        System.out.println("A primitív tömb legnagyobb eleme: " + legnagyobb);

        Integer[] oTömb = new Integer[tömb.length];
        for (int i = 0; i < tömb.length; i++) {
            oTömb[i] = tömb[i];
        }

        System.out.println("Az objektum típusú tömb elemei: " + Arrays.toString(oTömb));

        // Véletlenszám generálása és ezek egy tömbbe tárolása
        Random random = new Random();
        int[] rndTömb = new int[10];
        System.out.print("A tömb elemei, amelyek véletlenszámok 5 és 35 között: ");
        for (int i = 0; i < rndTömb.length; i++) {
            rndTömb[i] = random.nextInt(5, 35);
            System.out.print(rndTömb[i] + " ");
        }
        System.out.println();
    }

    private static int[] buborékrendezés(final int[] tömb) {
        for (int i = 0; i < tömb.length; i++) {
            for (int j = 0; j < tömb.length - i - 1; j++) {
                if (tömb[j] > tömb[j + 1]) {
                    int temp = tömb[j];
                    tömb[j] = tömb[j + 1];
                    tömb[j + 1] = temp;
                }
            }
        }
        return tömb;
    }

    private static void minimumkiválasztásosRendezés(final int[] tömb) {
        for (int i = 0; i < tömb.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < tömb.length; j++) {
                if (tömb[minElementIndex] > tömb[j]) {
                    minElementIndex = j;
                }
            }

            if (minElementIndex != i) {
                int temp = tömb[i];
                tömb[i] = tömb[minElementIndex];
                tömb[minElementIndex] = temp;
            }
        }
    }
}