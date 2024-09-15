package AnimalShelter;

public class Dog extends Animal {
    public Dog(String name, double weight, int age) throws AnimalException {
        super(name, weight, age, "Kutya");
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " vau-vau!");
    }
}