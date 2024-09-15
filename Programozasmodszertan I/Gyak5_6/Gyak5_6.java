package gyak5_6;

import java.util.ArrayList;
import java.util.List;

public class Gyak5_6 {
    public static void main(String[] args){

        //OOP alapok

        /*
        Az OOP 4 alapelve:
        Absztrakció (abstraction)
        Egységbezárás (encapsulation)
        Öröklődés (inheritance)
        Polimorfizmus v. sokalakúság (polymorphism)
         */

        Cat cica1 = new Cat();
        //cica1.name = "Cirmi";
        //System.out.println(cica1.name);
        cica1.setName("Cirmi");
        System.out.println(cica1.getName());

        Cat cica2 = new Cat("Félix", 2, "sziámi", "kandúr", Color.GREY);

        System.out.println(cica2);

        //Példánymetódusok hívása
        cica1.taplalkozas("csirkehús");
        cica2.taplalkozas("egér");

        //Statikus metódus hívása

        Cat.hangotAd();

        //Menhely

        //Példányosítás

        AnimalShelter menhely = new AnimalShelter();
        menhely.bekerul(cica1);
        menhely.bekerul(cica2);

        //Állatok kiíratása
        System.out.println(menhely.getShelter());

        menhely.orokbefogadas(cica2);
        System.out.println(menhely.getShelter());

        //Mikor nem működik a sima remove metódus?

        menhely.bekerul(new Cat("Lumi"));
        System.out.println(menhely.getShelter());

        menhely.orokbefogadas(new Cat("Lumi"));
        System.out.println(menhely.getShelter());

        //Családalapítás

        //Statikusan

        Cat utod = Cat.csaladAlapitas(cica2, cica1);
        System.out.println(utod);

        //Dinamikusan

        Cat utod2 = cica2.csaladotAlapit(cica1);
        System.out.println(utod2);

        Cat cica3 = new Cat("Cilike");
        System.out.println(cica3.getName());
        cica3.setName("Frédi");
        System.out.println(cica3.getName());

        //-------------------------------------------------
       // Mammal mammal = new Mammal();


        Dog doggie = new Dog("Fifike", true);
        System.out.println(doggie.getName());


        Dog dog = new Dog("Blöki", true);
        Dog dog2 = new Dog("Fifike", false);

        AnimalShelter kutyaMenhely = new AnimalShelter();
        kutyaMenhely.kutyaMenhely(dog);
        kutyaMenhely.kutyaMenhely(dog2);
        kutyaMenhely.kutyaMenhely(new Dog("Cézár", true));
        kutyaMenhely.kutyaMenhely(new Dog("Rex", false));

        kutyaMenhely.kutyaOrokbefogadas(new Dog("Cézár", true));

        dog.giveSound();
        cica1.giveSound();
        

    }
}
