package _06_JavaBeans;

import java.io.Serializable;

// JavaBeans konstrukció
public class Animal implements Serializable {
    // Példányváltozók - mind privátak
    private String name;
    private int weight;
    private double velocity;
    private boolean full;

    // Alapértelmezett konstruktor
    public Animal() {
    }

    public Animal(String name) {
        this(name, 0);
    }

    public Animal(String name, int weight) {
        this.name = name; // this kulcsszó: az aktuális objektumot jelenti; egy pszeudo-változó, aminek nem adhatunk értéket
        this.weight = weight;
    }

    // Példányváltozók lekérdező és módosító metódusai -> Getter-ek és Setter-ek
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getVelocity() {
        return velocity;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public boolean isFull() {
        return full;
    }

    public void setFull(boolean full) {
        this.full = full;
    }

    public void introduceSelf() {
        //System.out.println("My name is " + name);
        System.out.println("My name is " + this.getName());
    }
}