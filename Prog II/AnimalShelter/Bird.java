package AnimalShelter;

public class Bird extends Animal {
    public Bird(String name, double weight, int age) throws AnimalException {
        super(name, weight, age, "Madár");
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " csip-csip!");
    }
}