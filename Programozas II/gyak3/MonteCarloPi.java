package __Gyakorlat;

import java.util.Random;

/* A Monte-Carlo-módszert az 1940-es években fejlesztette ki Stanislaw Ulam */
public class MonteCarloPi {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            calculatePi();
        }
    }

    /* Rajzoljunk egy egység sugarú kört egy négyzetbe majd dobjunk véletlenszerűen pontokat ebbe a négyzetbe.
     * Ha megszámoljuk mennyi van a körön belül már közelítőleg tudjuk a PI értékét.
     * Ha növelni akarjuk a pontosságot, csak használjunk több pontot.
     * Az egység sugarú kör területe PI. A kört befoglaló négyzet oldalhosszúsága a = 2. A négyzet területe 4.
     * A kör és a négyzet területaránya π/4, tehát
     * PI = 4 x (a kör területére eső találatok száma) / (a négyzet területére eső összes találat száma) */

    private static void calculatePi() {
        Random random = new Random();
        int numOfAttempts = 100_000_000, numOfDesiredPoints = 0;

        for (int i = 0; i < numOfAttempts; i++) {
            double x = random.nextDouble(), y = random.nextDouble();
            // ki kell válogatni azokat az x-y párokat, melyekre x^2 + y^2 <= 1, és összeszámoljuk
            if (Math.pow(x, 2) + Math.pow(y, 2) <= 1) {
                numOfDesiredPoints++;
            }
        }

        double pi = 4.0 * numOfDesiredPoints / numOfAttempts;
        System.out.printf("PI=%.6f%n", pi);
    }
}