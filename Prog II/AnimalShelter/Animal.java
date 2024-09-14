package AnimalShelter;

public class Animal {
    private final String name;
    private final double weight;
    private final int age;
    private final String species;

    public Animal(String name, double weight, int age, String species) throws AnimalException {
        if (name.isEmpty()) throw new AnimalException(ErrorType.INVALID_NAME);
        if (weight <= 0) throw new AnimalException(ErrorType.INVALID_WEIGHT);
        if (age < 0) throw new AnimalException(ErrorType.INVALID_AGE);
        if (species.isEmpty()) throw new AnimalException(ErrorType.INVALID_SPECIES);
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public int getAge() {
        return age;
    }

    public String getSpecies() {
        return species;
    }

    public void makeSound() {
        System.out.println("Állat hangja.");
    }
}