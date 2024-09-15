package __Gyakorlat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Readingelés {
    public static void main(String[] args) throws IOException {
        /* BufferedReader */
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Kérem, adjon meg egy sort: ");
        String line = reader.readLine(); // Sor beolvasása
        System.out.println("Beolvasott sor: " + line);

        /* Scanner */
        Scanner billentyu = new Scanner(System.in);
        System.out.print("Kérem az első számot: ");
        int a = billentyu.nextInt();
        System.out.print("Kérem a második számot: ");
        int b = billentyu.nextInt();
        System.out.printf("Összeadás: %d + %d = %d\n", a, b, a + b);
        System.out.printf("Kivonás: %d - %d = %d\n", a, b, a - b);
        System.out.printf("Szorzás: %d * %d = %d\n", a, b, a * b);
        System.out.printf("Osztás: %d / %d = %d\n", a, b, a / b);
        if (a > 0 && b > 0) {
            System.out.printf("Maradék: %d %% %d = %d\n", a, b, a % b);
        }

        System.out.print("Kérek egy tetszőleges szám karaktert: ");
        char karakter = (char) System.in.read();

        // switch (v1)
        switch (karakter) {
            case '0':
                System.out.println("nulla");
                break;
            case '1':
                System.out.println("egy");
                break;
            case '2':
                System.out.println("kettő");
                break;
            case '3':
                System.out.println("három");
                break;
            case '4':
                System.out.println("négy");
                break;
            case '5':
                System.out.println("öt");
                break;
            case '6':
                System.out.println("hat");
                break;
            case '7':
                System.out.println("hét");
                break;
            case '8':
                System.out.println("nyolc");
                break;
            case '9':
                System.out.println("kilenc");
                break;
            default:
                System.out.println("Nem szám karakter");
        }

        // switch (v2)
        /*switch (karakter) {
            case '0' -> System.out.println("nulla");
            case '1' -> System.out.println("egy");
            case '2' -> System.out.println("kettő");
            case '3' -> System.out.println("három");
            case '4' -> System.out.println("négy");
            case '5' -> System.out.println("öt");
            case '6' -> System.out.println("hat");
            case '7' -> System.out.println("hét");
            case '8' -> System.out.println("nyolc");
            case '9' -> System.out.println("kilenc");
            default -> System.out.println("Nem szám karakter");
        }*/
    }
}