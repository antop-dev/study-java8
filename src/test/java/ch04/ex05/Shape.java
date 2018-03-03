package ch04.ex05;

abstract public class Shape {
    private Point point;

    public Shape(Point point) {
        this.point = point;
    }

    public void moveBy(double dx, double dy) {
        point = new Point(point.getX() + dx, point.getY() + dy);
    }

    protected final Point getPoint() {
        return new Point(point.getX(), point.getY());
    }

    protected abstract Point getCenter();

}
