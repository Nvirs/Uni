package gyak5_6;

public abstract class Mammal {

    private String species;

    public void reproduction(){
        System.out.println("Az emlősök elevenszülők.");
    }

    // konstruktorok

    public Mammal(String species) {
        this.species = species;
    }

    public Mammal(){}

    // getter-setter


    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }


}
