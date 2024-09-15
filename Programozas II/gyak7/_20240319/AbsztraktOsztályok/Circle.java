package _20240319.AbsztraktOsztályok;

public class Circle extends Shape {
    public Circle(double dimension) {
        super(dimension);
    }

    @Override
    public double calculateArea() {
        return Math.PI * dimension * dimension;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * dimension;
    }

    @Override
    public double calculateSurfaceArea() {
        return 4 * Math.PI * dimension * dimension;
    }

    @Override
    public double calculateVolume() {
        return (4.0 / 3.0) * Math.PI * dimension * dimension * dimension;
    }
}