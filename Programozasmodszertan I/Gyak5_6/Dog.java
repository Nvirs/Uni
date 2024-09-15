package gyak5_6;

public class Dog extends Mammal implements Animal{

    private String name;
    private String owner;
    private boolean isCute;

    //getters - setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public boolean isCute() {
        return isCute;
    }

    public void setCute(boolean cute) {
        isCute = cute;
    }

    //konstruktorok
    public Dog(){}


    public Dog(String name, boolean cute){
        this.name = name;
        this.isCute = cute;
    }

    public Dog(String name, String owner){
        this.name = name;
        this.owner = owner;
    }

    //teljes konstruktor
    //hivatkozzuk az ősosztályt is

    public Dog(String species, String name, String owner){
        super(species); //ősosztály konstruktorhívása
        this.name = name;
        this.owner = owner;
    }

    @Override // létező metódus felüldefiniálása
    public void reproduction(){ //Mammal osztályból
        System.out.println("A kutya emlős, tehát elevenszülő.");
    }


    @Override
    public void eat(String food) {
        System.out.println("A kutya kedvenc kajája a: " + food);
    }

    @Override
    public void giveSound() {
        System.out.println("Vauvau.");
    }
}
