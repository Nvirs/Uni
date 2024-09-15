package AnimalShelter;

public class Cat extends Animal {
    // Paraméteres konstruktor
    public Cat(String name, double weight, int age) throws AnimalException {
        super(name, weight, age, "Macska");
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " miau-miau!");
    }
}