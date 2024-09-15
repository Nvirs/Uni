package _12_Kivételek;

import java.time.DayOfWeek;
import java.util.Scanner;

public class Exceptions {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Adj meg egy számot: ");
        int number = input.nextInt();

        int result = 100 / number;
        System.out.printf("100 / %d = %d%n", number, result);

        String[] names = new String[]{"Ferrari", "McLaren", "Mercedes", "Reanult"};
        System.out.println("A kedvenc autó: " + names[number]);

        DayOfWeek today = DayOfWeek.valueOf(names[number]);
        System.out.println("A program sosem érhet el idáig!");
        System.out.println("Még akkor sem ha ma " + today + " nap van");
    }

    /*
     * Kivételek hierarchiája
     *
     *                   Throwable
     *                   /      \
     *             Exception    Error
     *              /
     *     RuntimeException
     */
}