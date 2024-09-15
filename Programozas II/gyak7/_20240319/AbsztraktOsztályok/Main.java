package _20240319.AbsztraktOsztályok;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.getUserInput();

        // Polimorfizmus következménye - 1
        /*Shape shape = new Circle(12);
        System.out.println(shape.calculateArea());*/

        // Polimorfizmus következménye - 2
        Shape shape = new Rectangle(5);
        display(shape);
        shape = new Circle(3);
        display(shape);

        /* Shape shape1 = new Shape(5) { ... }; -> ???
         * nem közvetlen példányosítás történik, hanem egy ún. névtelen osztály jön létre,
         * amely kiterjeszti az absztrakt osztályt és megvalósítja az összes absztrakt metódust.
         * */
    }

    // Statikus metódus, amely megjeleníti az alakzat területét és kerületét
    private static void display(Shape shape) {
        System.out.println("Terület: " + shape.calculateArea());
        System.out.println("Kerület: " + shape.calculatePerimeter());
        System.out.println();
    }
}