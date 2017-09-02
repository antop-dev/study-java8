package ch04;

import ch04.ex05.Line;
import ch04.ex05.Point;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Ex12Test {

    @Test
    public void test01() {
        Point p1 = new Point(10, 20);
        Point p2 = new Point(25, 30);

        Line line = new Line(p1, p2);
        for (int i = 0; i < 10000; i++) {
            line.moveBy(10, 10);
        }
    }

    public void test02() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Point p1 = new Point(10, 20);
        Point p2 = new Point(25, 30);

        Line line = new Line(p1, p2);

        for (int i = 0; i < 10000; i++) {
            Method moveBy = Line.class.getDeclaredMethod("moveBy", new Class[]{double.class, double.class});
            moveBy.invoke(line, new double[]{10, 10});
        }
    }

}
