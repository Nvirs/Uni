package gyak5_6;

import java.util.Random;
import java.util.Scanner;

public class Cat implements Animal{

    private String name;
    private int age;
    private String breed;
    private String gender;
    private Color color;
    //Módosítok: private, protected, pckage private, public

    //Getterek - setterek

    public String getName() {
        return name;
    }

    public void setName(String name) {
        boolean containsNumber = false;
        for(int i = 0; i < name.length(); i++){
            if(Character.isDigit(name.charAt(i))){
                System.out.println("A név nem tartalmazhat számot!");
                containsNumber = true;
                break;
            }
        }
        if(!containsNumber){
            this.name = name;
            System.out.println("Sikeres módosítás.");
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    //konstruktorok

    public Cat(String name){
        this.name = name;
    }

    public Cat(){

    }

    public Cat(String name, int age, String breed, String gender, Color color) {
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.gender = gender;
        this.color = color;
    }

    //toString


    @Override
    public String toString() {
        return this.name + ", " + this.age + " éves " + this.color + ", " + this.breed + " " + this.gender;
    }

    // Metódusok az osztályban

    //Példánymetódus

    public void taplalkozas(String taplalek){
        System.out.println(this.name + " " + taplalek + "-t eszik éppen.");
    }

    //statikus metódus

    public static void hangotAd(){
        System.out.println("Miauuuu.");
    }

    public static Cat csaladAlapitas(Cat him, Cat nosteny){
        int utodAge = 0;
        String utodBreed = nosteny.getBreed();
        Random rnd = new Random();
        Color[] colors = {him.getColor(), nosteny.getColor()};
        Color utodColor = colors[rnd.nextInt(2)];
        String utodName = him.getName() + nosteny.getName();
        String[] genders = {"nőstény", "kandúr"};
        String utodGender = genders[rnd.nextInt(2)];

        Cat utod = new Cat(utodName, utodAge, utodBreed, utodGender, utodColor);
        return utod;
    }

    // Ugyanez dinamikusan

    public Cat csaladotAlapit(Cat anyacica){
        int utodAge = 0;
        String utodBreed = anyacica.getBreed();
        Random rnd = new Random();
        Color[] colors = {this.getColor(), anyacica.getColor()};
        Color utodColor = colors[rnd.nextInt(2)];
        String utodName = this.getName() + anyacica.getName();
        String[] genders = {"nőstény", "kandúr"};
        String utodGender = genders[rnd.nextInt(2)];

        Cat utod = new Cat(utodName, utodAge, utodBreed, utodGender, utodColor);
        return utod;
    }

    @Override
    public void eat(String food) {
        System.out.println("A macska mindent eszik, csak a " + food + "-ot nem.");
    }

    @Override
    public void giveSound() {
        System.out.println("Miau.");
    }
}
