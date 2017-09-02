package ch04;

import ch04.ex02.LabeledPoint;
import ch04.ex02.Point;
import org.junit.Test;

public class Ex02Test {

    @Test
    public void point() {
        Point p1 = new LabeledPoint("a",1,1);
        Point p2 = new LabeledPoint("a",1,1);

        System.out.println("p1.toString() = " + p1);
        System.out.println("p1.hashCode() = " + p1.hashCode());

        System.out.println("p2.toString() = " + p2);
        System.out.println("p2.hashCode() = " + p2.hashCode());

        System.out.println("p1 == p2 ? " + (p1 == p2));
        System.out.println("p1.equals(p2) ? " + p1.equals(p2));
        System.out.println("p2.equals(p1) ? " + p2.equals(p1));
    }

    @Test
    public void labelPoint() {
        Point p1 = new Point(1,1);
        Point p2 = new Point(1,1);

        System.out.println("p1.toString() = " + p1);
        System.out.println("p1.hashCode() = " + p1.hashCode());

        System.out.println("p2.toString() = " + p2);
        System.out.println("p2.hashCode() = " + p2.hashCode());

        System.out.println("p1 == p2 ? " + (p1 == p2));
        System.out.println("p1.equals(p2) ? " + p1.equals(p2));
        System.out.println("p2.equals(p1) ? " + p2.equals(p1));
    }



}
