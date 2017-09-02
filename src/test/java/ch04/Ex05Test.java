package ch04;


import ch04.ex05.Circle;
import ch04.ex05.Line;
import ch04.ex05.Point;
import ch04.ex05.Rectangle;
import org.junit.Test;

public class Ex05Test {

    @Test
    public void circle() {
        Circle c1 = new Circle(new Point(10, 10), 20);
        Circle c2 = c1.clone();

        System.out.println(c1);
        System.out.println(c2);
    }

    @Test
    public void rectangle() {
        Rectangle r1 = new Rectangle(new Point(10, 10), 100, 200);
        Rectangle r2 = r1.clone();

        System.out.println(r1);
        System.out.println(r2);
    }

    @Test
    public void line() {
        Line l1 = new Line(new Point(30, 20), new Point(10, 10));
        Line l2 = l1.clone();

        System.out.println(l1);
        System.out.println(l2);
    }

}
