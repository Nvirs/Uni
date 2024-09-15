package __Gyakorlat;

import java.util.Scanner;

public class Ciklusok {
    public static void main(String[] args) {
        Scanner billentyu = new Scanner(System.in);
        System.out.print("Kérek egy számot: ");
        int n = billentyu.nextInt(), fakt = 1;
        for (int i = 1; i <= n; i++) {
            fakt *= i;
        }
        System.out.printf("%d! = %d\n", n, fakt);
        int faktoriális = faktoriális(n);
        System.out.printf("%d! = %d\n", n, faktoriális);

        int osszeg = 0;
        System.out.print("Kérek egy számot: ");
        while (billentyu.hasNextInt()) {
            //int szam = billentyu.nextInt();
            //osszeg += szam;
            osszeg += billentyu.nextInt();
            System.out.print("Kérek egy számot: ");
        }
        System.out.println("A számok összege = " + osszeg);

        System.out.print("Adjon meg két számot: ");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt(), b = scanner.nextInt(), r = a % b;
        while (r != 0) {
            a = b;
            b = r;
            r = a % b;
        }
        System.out.printf("A legnagyobb közös osztó = %d\n", b);
        System.out.printf("A legnagyobb közös osztó = %d\n", gcd(a, b));

        System.out.println("Adj meg egész számokat, majd írd be egy tetszőleges karaktert a végjelnek!");

        /* minimum érték keresése megadott számok alapján */
        int minimumÉrték = Integer.MAX_VALUE;
        int darabszám = 0, összeg = 0; // átlagszámításhoz kell

        while (scanner.hasNextInt()) {
            int szám = scanner.nextInt();
            if (szám < minimumÉrték) {
                minimumÉrték = szám;
            }
            összeg += szám; // átlagszámításhoz kell
            darabszám++; // átlagszámításhoz kell
        }

        /*if (minimumÉrték == Integer.MAX_VALUE) {
            System.out.println("Nem adtál meg számot.");
        } else {
            System.out.println("A megadott számok közül a legkisebb: " + minimumÉrték);
        }*/

        // Ternary operator: ?:
        //System.out.println(minimumÉrték == Integer.MAX_VALUE ? "Nem adott meg számot." : "A megadott számok közül a legkisebb: " + minimumÉrték);

        // átlagszámítás bevezetése után
        if (darabszám == 0) {
            System.out.println("Nem adott meg számot.");
        } else {
            double atlag = (double) összeg / darabszám;
            System.out.println("A megadott számok közül a legkisebb: " + minimumÉrték);
            System.out.println("A megadott számok átlaga: " + atlag);
        }
    }

    private static int faktoriális(int szám) {
        /*if (szám == 0 || szám == 1) return 1;
        return szám * faktoriális(szám - 1);*/
        return (szám == 0 || szám == 1) ? 1 : szám * faktoriális(szám - 1);
    }

    private static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }
}