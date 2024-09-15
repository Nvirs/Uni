package gyak5_6;

import java.util.ArrayList;
import java.util.List;

public class AnimalShelter {

    private List<Cat> shelter = new ArrayList<>();
    private List<Dog> dogShelter = new ArrayList<>();

    //getter-setter


    public List<Cat> getShelter() {
        return shelter;
    }

    public void setShelter(List<Cat> shelter) {
        this.shelter = shelter;
    }

    public List<Dog> getDogShelter() {
        return dogShelter;
    }

    public void setDogShelter(List<Dog> dogShelter) {
        this.dogShelter = dogShelter;
    }

    //konstruktorok


    public AnimalShelter(List<Cat> shelter) {
        this.shelter = shelter;
    }

    public AnimalShelter(){

    }

    //Metódusok

    //add, remove metódus

    // Menhelyre kerül (add)

    public List<Cat> bekerul(Cat cat){
        shelter.add(cat);
        System.out.println(cat.getName() + " sajnos menhelyre került.");
        return shelter;
    }

    // Örökbefogadás (remove)

    public List<Cat> orokbefogadas(Cat cat){
        //shelter.remove(cat);
        for(int i = 0; i < shelter.size(); i++){
            if(cat.getName().equals(shelter.get(i).getName())){
                shelter.remove(shelter.get(i));
            }
        }
        System.out.println("Viszlát " + cat.getName() + ", boldog gazdis éveket!");
        return shelter;
    }

    //Opcionális házi: Írjunk módosító metódust az AnimalShelter osztályba.

    //Kutyamenhely feltöltő metódus:

    public List<Dog> kutyaMenhely(Dog dog){
        dogShelter.add(dog);
        return dogShelter;
    }

    //Örökbefogadás metódus - ha cuki.

    public List<Dog> kutyaOrokbefogadas(Dog dog){
        if(dog.isCute()){
            for(int i = 0; i < dogShelter.size(); i++){
                if(dog.getName().equals(dogShelter.get(i).getName())){
                    System.out.println(dogShelter.get(i).getName() + " kutyit örökbefogadták! Boldog gazdis éveket!");
                    dogShelter.remove(dogShelter.get(i));
                }
            }
        }else{
            System.out.println(dog.getName() + " sajnos marad a menhelyen. :(");
        }
        return dogShelter;
    }




}
