package ch04.ex05;

public class Rectangle extends Shape implements Cloneable {
    private double width;
    private double height;

    public Rectangle(Point topLeft, double width, double height) {
        super(topLeft);
        this.width = width;
        this.height = height;
    }

    @Override
    protected Point getCenter() {
        Point point = getPoint();
        return new Point(point.getX() + (width / 2), point.getY() + (height /2));
    }

    public Point getTopLeft() {
        return getPoint();
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public Rectangle clone() {
        return new Rectangle(getPoint(), width, height);
    }
}
