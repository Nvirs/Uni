package _05_Láthatóság;

import _04_OsztályokObjektumok.Állat;

public class Láthatóság {
    public static void main(String[] args) {
        Állat macska = new Állat("Cirmi"); // működik, ha a konstruktor publikus
        macska.név = "Doromboló"; // működik, ha a 'név' publikus
        System.out.println(macska.név);
        //macska.sebesség = 10; nem működik, mert a sebesség nem publikus, hanem package private
    }
}