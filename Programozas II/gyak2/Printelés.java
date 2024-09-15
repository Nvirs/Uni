package __Gyakorlat;

import java.text.DecimalFormat;
import java.util.Locale;

public class Printelés {
    public static void main(String[] args) {
        int változó = 5;
        System.out.println("Változó értéke: " + változó);
        System.out.printf("Változó értéke: %d (%%n sortöréssel)%n", változó); // %: formázó karakter
        System.out.printf("Változó értéke: %d (\\n sortöréssel)\n", változó); // %n és \n is használható sortörésre printf esetén
        System.out.println("Új sor");

        int a, b, c;
        a = 5;
        b = 3;
        c = a + b;
        // int a = 5, b = 3, c = a + b; // rövidebb változat
        System.out.println("a + b = " + a + " + " + b + " = " + c);
        System.out.printf("a + b = %d + %d = %d\n", a, b, c);

        double d = 3.14;
        float e = 5.2f;

        // println esetén ponttal vannak megjelenítve a lebegőpontos számok
        // -> ennek oka, hogy a kimeneti szöveg generálása a String típusú objektumok toString metódusán keresztül történik.
        // -> A double és float típusok toString metódusa a Java nyelv alapértelmezett formázási szabályait követi.
        System.out.println("d / e = " + d + " / " + e + " = " + d / e);
        // printf esetén vesszővel vannak megjelenítve a lebegőpontos számok
        // -> ennek oka, hogy formázási sablon (%f) alkalmazkodik a helyi beállításokhoz, és ezért lehet pont vagy vessző a lebegőpontos számok elválasztó karaktere.
        // -> Például, az angolszász országokban általában a pontot (.) használják tizedesjelként, míg az európai országokban és más területeken a vesszőt (,).
        System.out.printf("d / e = %f / %f = %f\n", d, e, d / e);
        System.out.printf("d / e = %f / %f = %.3f\n", d, e, d / e);

        double PI = 3.1415926535897;
        System.out.println("PI értéke: " + PI);
        System.out.println("PI értéke: " + String.format(Locale.US, "%.3f", PI));
        System.out.println(String.format("PI értéke: %.2f", PI));
        System.out.printf("PI értéke: %.5f%n", PI);
        DecimalFormat decimalFormat = new DecimalFormat("#.####"); // #: formázási mintához szükséges (helyőrző) karakter, mely jelzi, hogy a megfelelő helyekre számjegyeket kell elhelyezni
        System.out.println("PI értéke: " + decimalFormat.format(PI));
    }
}