package _03_Konverzió;

public class Conversion_szukites {
    public static void main(String[] args) {
        byte bájt = 1;
        int egész;
        long hosszúEgész = 123;
        double hosszúValós;

        // Explicit típus konverzió -> itt adódhat az, hogy információvesztés történik
        // Ezért a fordító megköveteli, hogy a konverziót explicit módon jelöljük --> típuskényszerítés ("castolás")
        egész = (int) hosszúEgész;
        /*
        * Amikor két byte típusú változót adunk össze (bájt + bájt), az összeg egy int típusú változó lesz,
        * mivel az alapértelmezett számítások Java-ban int méretű számokon történnek.
        * Ez azért van, mert a kisebb típusú adatokat automatikusan először int-re emelik fel az aritmetikai műveletek során.
        * Ez a kisebb típusú operandusok védelmére és az adatvesztés megelőzésére van,
        * mivel egy byte típusú változó tartományának összege könnyen túllépheti az byte típusú maximális értékét.
        * */
        byte x = (byte) (bájt + bájt);

        // Explicit konverzió lehet szűkítés és bővítés is!
        //hosszúEgész = (long) egész;

        // double -> float: IEEE kerekítés
        hosszúValós = 34028234663859900000000000000000000000.0;
        float valós = (float) hosszúValós;
        System.out.println("double -> float");
        System.out.printf("double %f\nfloat  %f\n\n", hosszúValós, valós);

        // double, float -> long: kerekítés 0 felé
        hosszúValós = 9223372036854775900.001;
        hosszúEgész = (long) hosszúValós;
        System.out.println("double, float -> long");
        System.out.printf("double %f\nlong   %d\n\n", hosszúValós, hosszúEgész);

        // double, float -> int: kerekítés 0 felé
        egész = (int) hosszúValós;
        System.out.println("double, float -> int");
        System.out.printf("double %f\nint    %d\n", hosszúValós, egész);
    }
}