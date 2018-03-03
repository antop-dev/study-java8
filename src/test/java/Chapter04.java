import ch02.ex17.Queue;
import ch04.ex06.DiscountedItem;
import ch04.ex06.Item;
import ch04.ex07.Color;
import ch04.ex08.ClassToString;
import org.junit.Test;

import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Chapter04 {

	@Test
	public void ex01() {
		// ch04.ex01.Point
		// ch04.ex01.LabeledPoint
	}

	@Test
	public void ex0201() {
		ch04.ex02.Point p1 = new ch04.ex02.Point(1, 1);
		ch04.ex02.Point p2 = new ch04.ex02.Point(1, 1);

		System.out.println("p1.toString() = " + p1);
		System.out.println("p1.hashCode() = " + p1.hashCode());

		System.out.println("p2.toString() = " + p2);
		System.out.println("p2.hashCode() = " + p2.hashCode());

		System.out.println("p1 == p2 ? " + (p1 == p2));
		System.out.println("p1.equals(p2) ? " + p1.equals(p2));
		System.out.println("p2.equals(p1) ? " + p2.equals(p1));
	}

	@Test
	public void ex0202() {
		ch04.ex02.LabeledPoint p1 = new ch04.ex02.LabeledPoint("a", 1, 1);
		ch04.ex02.LabeledPoint p2 = new ch04.ex02.LabeledPoint("a", 1, 1);

		System.out.println("p1.toString() = " + p1);
		System.out.println("p1.hashCode() = " + p1.hashCode());

		System.out.println("p2.toString() = " + p2);
		System.out.println("p2.hashCode() = " + p2.hashCode());

		System.out.println("p1 == p2 ? " + (p1 == p2));
		System.out.println("p1.equals(p2) ? " + p1.equals(p2));
		System.out.println("p2.equals(p1) ? " + p2.equals(p1));
	}

	@Test
	public void ex03() {
		// ch04.ex03.Point
		// ch04.ex03.LabeledPoint.toString()
	}

	@Test
	public void ex04() {
		// circle
		ch04.ex04.Point p = new ch04.ex04.Point(10, 10);
		ch04.ex04.Circle c = new ch04.ex04.Circle(p, 20);
		System.out.println("center = " + c.getCenter());

		// rectangle
		ch04.ex04.Rectangle r = new ch04.ex04.Rectangle(new ch04.ex04.Point(10, 10), 100, 200);
		System.out.println("rectangle center = " + r.getCenter());

		// line
		ch04.ex04.Point from = new ch04.ex04.Point(30, 20);
		ch04.ex04.Point to = new ch04.ex04.Point(10, 10);
		ch04.ex04.Line line = new ch04.ex04.Line(from, to);
		System.out.println("line center = " + line.getCenter());
	}

	@Test
	public void ex05() {
		// circle
		ch04.ex05.Circle c1 = new ch04.ex05.Circle(new ch04.ex05.Point(10, 10), 20);
		ch04.ex05.Circle c2 = c1.clone();

		System.out.println(c1);
		System.out.println(c2);

		// rectangle
		ch04.ex05.Rectangle r1 = new ch04.ex05.Rectangle(new ch04.ex05.Point(10, 10), 100, 200);
		ch04.ex05.Rectangle r2 = r1.clone();

		System.out.println(r1);
		System.out.println(r2);

		// line
		ch04.ex05.Line l1 = new ch04.ex05.Line(new ch04.ex05.Point(30, 20), new ch04.ex05.Point(10, 10));
		ch04.ex05.Line l2 = l1.clone();

		System.out.println(l1);
		System.out.println(l2);
	}

	@Test
	public void ex06() {
		DiscountedItem x = new DiscountedItem("Item", 1000, 200);
		Item y = new Item("Item", 1000);
		DiscountedItem z = new DiscountedItem("Item", 1000, 100);

		System.out.println(x.equals(y)); // true
		System.out.println(y.equals(z)); // true
		System.out.println(x.equals(z)); // false
	}

	@Test
	public void ex07() {
		Color color = Color.getBlue();
		System.out.println(color);
	}

	@Test
	public void ex08() {
		String[] strings = new String[]{"a", "b", "c"};
		System.out.println("* array type");
		ClassToString.toString(strings.getClass());
		System.out.println();
		System.out.println("* generic type");
		ClassToString.toString(Override.class);
		System.out.println();
		System.out.println("* inner class");
		ClassToString.toString(Queue.Iterator.class);
		System.out.println();
		System.out.println("* primitive ");
		ClassToString.toString(double.class);
	}

	@Test
	public void ex09() {
		ch04.ex09.Employee e = new ch04.ex09.Employee("antop", 5000);
		System.out.println(e.toString());
	}

	@Test
	public void ex11() throws Exception {
		Class<?> clazz = Class.forName("java.lang.System");
		// out field
		Field field = clazz.getDeclaredField("out");
		Object out = field.get(null);
		// out.println method
		Method method = PrintStream.class.getDeclaredMethod("println", new Class[]{String.class});
		method.invoke(out, "Hello World!");
	}

	@Test
	public void ex1201() {
		ch04.ex05.Point p1 = new ch04.ex05.Point(10, 20);
		ch04.ex05.Point p2 = new ch04.ex05.Point(25, 30);

		ch04.ex05.Line line = new ch04.ex05.Line(p1, p2);
		for (int i = 0; i < 10000; i++) {
			line.moveBy(10, 10);
		}
	}

	@Test
	public void ex1202() throws Exception {
		ch04.ex05.Point p1 = new ch04.ex05.Point(10, 20);
		ch04.ex05.Point p2 = new ch04.ex05.Point(25, 30);

		ch04.ex05.Line line = new ch04.ex05.Line(p1, p2);

		for (int i = 0; i < 10000; i++) {
			Method moveBy = ch04.ex05.Line.class.getDeclaredMethod("moveBy", new Class[]{double.class, double.class});
			moveBy.invoke(line, new double[]{10, 10});
		}
	}

}
