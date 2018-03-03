package ch04.ex04;

public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(Point topLeft, double width, double height) {
        super(topLeft);
        this.width = width;
        this.height = height;
    }

    @Override
    public Point getCenter() {
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
}
