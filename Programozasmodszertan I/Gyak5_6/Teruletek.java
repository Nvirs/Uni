package feladatok;

import java.util.Scanner;

public class Teruletek implements Area{

    private double radius;
    private double area;
    private double alap;
    private double magassag;
    private double oldal1;
    private double oldal2;
    private final double PI = 3.14;
    private Sikidom sikidom;

    // konstruktor
    public Teruletek(Sikidom sikidom){
        this.sikidom = sikidom;
    }


    @Override
    public double calculateArea() {
        Scanner scn = new Scanner(System.in);
        switch(this.sikidom){
            case KOR:
                     System.out.println("Add meg a sugarat: ");
                     this.radius = scn.nextDouble();
                     this.area = Math.pow(this.radius, 2) * PI;
                     break;
            case HAROMSZOG:
                    System.out.println("Add meg az alapot: ");
                    this.alap = scn.nextDouble();
                    System.out.println("Add meg a magasságot: ");
                    this.magassag = scn.nextDouble();
                    this.area = this.alap * this.magassag / 2;
                    break;
            case NEGYZET:
                    System.out.println("Add meg az oldal hosszát: ");
                    this.oldal1 = scn.nextDouble();
                    this.area = this.oldal1 * this.oldal1;
                    break;
            case TEGLALAP:
                    System.out.println("Add meg az egyik oldal hosszát: ");
                    this.oldal1 = scn.nextDouble();
                    System.out.println("Add meg a másik oldal hosszát: ");
                    this.oldal2 = scn.nextDouble();
                    this.area = this.oldal1 * this.oldal2;
                    break;
            default:
                System.out.println("Nincs ilyen síkidom.");
        }
        System.out.println("A terület: " + this.area);
       return this.area;
    }
}


