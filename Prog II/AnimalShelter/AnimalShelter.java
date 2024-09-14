package AnimalShelter;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class AnimalShelter {
    List<Animal> animals = new ArrayList<>();

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void listAnimals() {
        if (animals.isEmpty()) {
            System.out.println("Nincs állat a menhelyen!");
            return;
        }

        System.out.println("Az állatok a menhelyen:");
        for (Animal animal : animals) {
            System.out.println(animal.getSpecies() + ": " +
                    animal.getName() + "(" + animal.getAge() + " éves, " + animal.getWeight() + " kg)");
        }
    }

    public void displayStatistics() {
        if (animals.isEmpty()) {
            System.out.println("Nincs állat a menhelyen!");
            return;
        }

        int totalAnimals = animals.size();
        int totalAge = 0;
        double totalWeight = 0;
        int countUnder10kg = 0;

        for (Animal animal : animals) {
            totalAge += animal.getAge();
            totalWeight += animal.getWeight();
            if (animal.getWeight() < 10) countUnder10kg++;
        }

        double averageAge = (double) totalAge / totalAnimals;
        double averageWeight = totalWeight / totalAnimals;
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        System.out.println("Állatok száma: " + totalAnimals + ".");
        System.out.println("Átlagéletkor: " + decimalFormat.format(averageAge) + " év.");
        System.out.println("Átlagtömeg: " + decimalFormat.format(averageWeight) + " kg.");
        System.out.println("10 kg alatti állatok száma: " + countUnder10kg + " db.");
    }
}