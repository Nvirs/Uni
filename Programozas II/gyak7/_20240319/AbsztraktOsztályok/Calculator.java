package _20240319.AbsztraktOsztályok;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Calculator implements UserInterface {
    private final Scanner scanner;

    public Calculator() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void displayMenu() {
        System.out.println("Válasszon az alábbi alakzatok közül:");
        System.out.println("0. Kilépés");
        System.out.println("1. Négyzet");
        System.out.println("2. Kör");
    }

    @Override
    public void getUserInput() {
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            if (choice == 0) {
                System.out.println("Kilépés...");
                break;
            }

            Shape shape;
            DecimalFormat decimalFormat = new DecimalFormat("#.###");

            switch (choice) {
                case 1 -> {
                    System.out.print("Adja meg a négyzet oldalhosszát: ");
                    double side = scanner.nextDouble();
                    shape = new Rectangle(side);
                    draw();
                    System.out.println("A négyzet területe: " + decimalFormat.format(shape.calculateArea()));
                    System.out.println("A négyzet kerülete: " + decimalFormat.format(shape.calculatePerimeter()));
                    System.out.println("A négyzet felszíne: " + decimalFormat.format(shape.calculateSurfaceArea()));
                    System.out.println("A négyzet térfogata: " + decimalFormat.format(shape.calculateVolume()));
                }
                case 2 -> {
                    System.out.print("Adja meg a kör sugarát: ");
                    double radius = scanner.nextDouble();
                    shape = new Circle(radius);
                    draw();
                    System.out.println("A kör területe: " + decimalFormat.format(shape.calculateArea()));
                    System.out.println("A kör kerülete: " + decimalFormat.format(shape.calculatePerimeter()));
                    System.out.println("A kör felszíne: " + decimalFormat.format(shape.calculateSurfaceArea()));
                    System.out.println("A kör térfogata: " + decimalFormat.format(shape.calculateVolume()));
                }
                default -> System.out.println("Érvénytelen választás.");
            }
        }
    }
}