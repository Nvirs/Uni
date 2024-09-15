package __Gyakorlat;

import java.util.Scanner;

/**
 * Kérjünk be egy bináris számot és írjuk ki a decimális megfelelőjét
 * Példa
 * Bemenet: 11100111
 * Kimenet: 231
 */
public class DecimalisBinaris {
    public static void main(String[] args) {
        //osztósMegfordítósMegoldás();
        kivonósMegoldás();
        //profiMegoldás();
    }

    public static void osztósMegfordítósMegoldás() {
        Scanner bemenet = new Scanner(System.in);
        System.out.print("Adjon meg egy pozitív egész számot: ");
        int szám = bemenet.nextInt();
        String binárisSzám = "";

        while (szám > 0) {
            binárisSzám += szám % 2;
            szám /= 2;
        }

        // bináris megjelenítés (v1)
        /*String fordított = "";
        for (int i = binárisSzám.length() - 1; i >= 0; i--) {
            fordított += binárisSzám.charAt(i);
        }*/

        // bináris megjelenítés (v2)
        String fordított = new StringBuilder(binárisSzám).reverse().toString();

        System.out.println("A(z) " + szám + " bináris alakja: " + fordított);
    }

    public static void kivonósMegoldás() {
        Scanner bemenet = new Scanner(System.in);
        System.out.print("Adjon meg egy pozitív egész számot: ");
        int szám = bemenet.nextInt();
        int eredetiSzám = szám;

        int kettőHatvány = 1;
        while (szám >= kettőHatvány * 2) {
            kettőHatvány *= 2;
        }

        String binárisSzám = "";
        while (kettőHatvány > 0) {
            if (szám >= kettőHatvány) {
                szám -= kettőHatvány;
                binárisSzám += "1";
            } else {
                binárisSzám += "0";
            }
            kettőHatvány /= 2;
        }

        System.out.println("A(z) " + eredetiSzám + " bináris alakja: " + binárisSzám);
    }

    private static void profiMegoldás() {
        Scanner bemenet = new Scanner(System.in);
        System.out.print("Adjon meg egy pozitív egész számot: ");
        int szám = bemenet.nextInt();
        System.out.println("A(z) " + szám + " bináris alakja: " + Integer.toString(szám, 2));
    }
}