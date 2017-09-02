package ch04.ex04;

public class Line extends Shape {
    private Point to;

    public Line(Point from, Point to) {
        super(from);
        this.to = to;
    }

    @Override
    public void moveBy(double dx, double dy) {
        super.moveBy(dx, dy);
        to = new Point(to.getX() + dx, to.getY() + dy);
    }

    @Override
    public Point getCenter() {
        Point from = getPoint();

        double x = from.getX() + ((to.getX() - from.getX()) /2);
        double y = from.getY() + ((to.getY() - from.getY()) /2);
        return new Point(x, y);
    }

    public Point getFrom() {
        return getPoint();
    }

    public Point getTo() {
        return new Point(to.getX(), to.getY());
    }
}
