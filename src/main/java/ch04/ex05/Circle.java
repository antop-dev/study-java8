package ch04.ex05;

public class Circle extends Shape implements Cloneable {
    private double radius;

    public Circle(Point center, double radius) {
        super(center);
        this.radius = radius;
    }

    @Override
    public Point getCenter() {
        return getPoint();
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public Circle clone() {
        return  new Circle(getPoint(), radius);
    }
}