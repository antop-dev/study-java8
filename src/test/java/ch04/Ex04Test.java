package ch04;

import ch04.ex04.Circle;
import ch04.ex04.Line;
import ch04.ex04.Point;
import ch04.ex04.Rectangle;
import org.junit.Test;

public class Ex04Test {

    @Test
    public void circle() {
        Point p = new Point(10, 10);
        Circle c = new Circle(p, 20);

        System.out.println("center = " + c.getCenter());
    }

    @Test
    public void rectangle() {
        Point p = new Point(10, 10);
        Rectangle r = new Rectangle(p, 100, 200);

        System.out.println("center = " + r.getCenter());
    }

    @Test
    public void line() {
        Point from = new Point(30, 20);
        Point to = new Point(10, 10);

        Line line = new Line(from, to);

        System.out.println("center = " + line.getCenter());
    }

}
