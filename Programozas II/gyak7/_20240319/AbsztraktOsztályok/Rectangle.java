package _20240319.AbsztraktOsztályok;

public class Rectangle extends Shape {
    public Rectangle(double dimension) {
        super(dimension);
    }

    @Override
    public double calculateArea() {
        return dimension * dimension;
    }

    @Override
    public double calculatePerimeter() {
        return 4 * dimension;
    }

    @Override
    public double calculateSurfaceArea() {
        return 6 * dimension * dimension;
    }

    @Override
    public double calculateVolume() {
        return dimension * dimension * dimension;
    }
}