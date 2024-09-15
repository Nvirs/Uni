package __Gyakorlat.Zarthelyi;

import java.util.Scanner;

public class ElsoFeladat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Tömb méretének bekérése
        System.out.print("Adja meg a tömb méretét: ");
        int size = scanner.nextInt();

        // Tömb létrehozása és feltöltése konzolról bekért értékekkel
        int[] numbers = new int[size];
        int evenNumberCount = 0, primeCount = 0;
        for (int i = 0; i < size; i++) {
            do {
                System.out.print("Adja meg a(z) " + (i + 1) + ". számot: ");
                numbers[i] = scanner.nextInt();
            } while (numbers[i] <= 0);
            // Páros és prímszámok keresése és megszámlálása
            if (isEven(numbers[i])) evenNumberCount++;
            if (isPrime(numbers[i])) primeCount++;
        }

        // Páros számok tárolása egy másik tömbbe; Prímszámok keresése és megszámlálása
        int[] evenNumbers = new int[evenNumberCount], primeNumbers = new int[primeCount];
        int evenIndex = 0, primeIndex = 0;
        for (int number : numbers) {
            if (isEven(number)) evenNumbers[evenIndex++] = number;
            if (isPrime(number)) primeNumbers[primeIndex++] = number;
        }

        // Eredmények kiíratása - páros számok
        if (evenNumbers.length == 0) System.out.println("Nem található páros szám.");
        else {
            System.out.print("Az adott számok között " + evenNumberCount + " darab páros szám van: ");
            int i = 0;
            for (int evenNumber : evenNumbers)
                System.out.print(evenNumber + (i++ < evenNumberCount - 1 ? ", " : "."));
        }

        // Eredmények kiíratása - prímszámok
        if (primeNumbers.length == 0) System.out.println("\nNem található prímszám.");
        else {
            System.out.print("\nAz adott számok között " + primeCount + " darab prímszám van: ");
            int i = 0;
            for (int prime : primeNumbers) System.out.print(prime + (i++ < primeCount - 1 ? ", " : "."));

            // Prímszámok tárolása egy másik tömbbe, melyeknek számjegyeinek összege is prímszám
            int[] primeNumbersWithPrimeDigitSum = new int[primeCount];
            int count = 0;
            for (int number : primeNumbers) {
                if (isPrime(digitSumCalculate(number)) && number > 10)
                    primeNumbersWithPrimeDigitSum[count++] = number;
            }

            // Eredmények kiíratása - prímszámok, melyeknek számjegyeinek összege is prím
            if (count > 0) {
                System.out.print("\nAz adott számok közül a következő prímszámoknak a számjegyeinek összege is prímszám: ");
                for (int j = 0; j < count; j++) System.out.print(primeNumbersWithPrimeDigitSum[j] + " ");
            } else System.out.println("\nNincs olyan prímszám, amelynek számjegyeinek összege is prímszám.");
        }
    }

    private static boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++)
            if (number % i == 0) return false;
        return true;
    }

    private static boolean isEven(int number) {
        // 1. megoldás
        /*if (number <= 0) return false;
        return number % 2 == 0;*/
        // 2. megoldás
        //return number <= 0 ? false : number % 2 == 0;
        // 3. megoldás
        return number > 0 && number % 2 == 0;
    }

    private static int digitSumCalculate(int number) {
        // 1. megoldás
        /*int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;*/

        // 2. megoldás
        return number == 0 ? 0 : number % 10 + digitSumCalculate(number / 10);
    }
}