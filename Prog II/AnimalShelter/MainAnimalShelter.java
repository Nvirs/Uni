package AnimalShelter;

import java.util.Scanner;

public class MainAnimalShelter {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            AnimalShelter animalShelter = new AnimalShelter();
            int choice;
            do {
                System.out.println("===========================================");
                System.out.println("*** MENÜ ***");
                System.out.println("1. Új kutya hozzáadása");
                System.out.println("2. Új macska hozzáadása");
                System.out.println("3. Új madár hozzáadása");
                System.out.println("4. Állatok listázása");
                System.out.println("5. Statisztika megjelenítése");
                System.out.println("0. Kilépés");
                System.out.println("===========================================");
                System.out.print("Válasszon a lehetőségek közül: ");

                // Ellenőrizzük, hogy az input egész szám-e
                while (!scanner.hasNextInt()) {
                    System.out.print("Érvénytelen választás! Kérem, válasszon újra: ");
                    scanner.next(); // Törölje a nem egész szám bemenetet
                }
                choice = scanner.nextInt();
                scanner.nextLine(); // Eltávolítja a sortörést

                switch (choice) {
                    case 1 -> addAnimal(animalShelter, "Kutya");
                    case 2 -> addAnimal(animalShelter, "Macska");
                    case 3 -> addAnimal(animalShelter, "Madár");
                    case 4 -> animalShelter.listAnimals();
                    case 5 -> animalShelter.displayStatistics();
                    case 0 -> System.out.println("Kilépés...");
                    default -> System.out.println("Érvénytelen választás! Kérem, válasszon újra.");
                }
            } while (choice != 0);
        }
    }

    public static void addAnimal(AnimalShelter shelter, String type) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Adja meg a " + type + " nevét: ");
            String name = scanner.nextLine();
            System.out.print("Adja meg a " + type + " tömegét (kg-ban): ");
            double weight = scanner.nextDouble();
            System.out.print("Adja meg a " + type + " életkorát: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // Eltávolítja a sortörést
            switch (type) {
                case "Kutya" -> shelter.addAnimal(new Dog(name, weight, age));
                case "Macska" -> shelter.addAnimal(new Cat(name, weight, age));
                case "Madár" -> shelter.addAnimal(new Bird(name, weight, age));
                default -> System.out.println("Ismeretlen állattípus!");
            }
        } catch (AnimalException e) {
            System.out.println("Hiba: " + e.getMessage());
        }
    }
}