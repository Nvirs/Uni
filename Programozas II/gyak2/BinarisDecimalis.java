package __Gyakorlat;

import java.util.Scanner;

/**
 * Kérjünk be egy bináris számot és írjuk ki a decimális megfelelőjét
 * Példa
 * Bemenet: 11100111
 * Kimenet: 231
 */
public class BinarisDecimalis {
    public static void main(String[] args) {
        //manuálisMódszer();
        profiMegoldás();
    }

    private static void manuálisMódszer() {
        Scanner bemenet = new Scanner(System.in);
        System.out.print("Adja meg a bináris számot: ");
        String binárisSzám = bemenet.nextLine();

        int decimálisSzám = 0, kettőhatvány = 1; // kettőhatvány kezdeti érték: 2^0 = 1
        for (int i = binárisSzám.length() - 1; i >= 0; i--) {
            char karakter = binárisSzám.charAt(i);
            int helyiérték = Character.getNumericValue(karakter); // '0' -> 0, '1' -> 1
            decimálisSzám += helyiérték * kettőhatvány;
            kettőhatvány *= 2;
        }

        System.out.println("A(z) " + binárisSzám + " decimális alakja: " + decimálisSzám);
    }

    private static void profiMegoldás() {
        Scanner bemenet = new Scanner(System.in);
        System.out.print("Adja meg a bináris számot: ");
        String binárisSzám = bemenet.nextLine();
        System.out.println("A(z) " + binárisSzám + " decimális alakja: " + Integer.parseInt(binárisSzám, 2));
    }
}