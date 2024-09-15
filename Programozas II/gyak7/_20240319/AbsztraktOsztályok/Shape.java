package _20240319.AbsztraktOsztályok;

abstract class Shape {
    protected double dimension;

    public Shape(double dimension) {
        this.dimension = dimension;
    }

    public abstract double calculateArea();

    public abstract double calculatePerimeter();

    public abstract double calculateSurfaceArea();

    public abstract double calculateVolume();
}