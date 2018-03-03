package ch04.ex05;

public class Line extends Shape implements Cloneable {
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
    protected Point getCenter() {
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

    @Override
    public Line clone() {
        return new Line(getPoint(), getTo());
    }
}
