import ch02.ex13.OsCpu;
import ch02.ex17.Queue;
import com.opencsv.bean.CsvToBeanBuilder;
import org.junit.Test;
import org.omg.CORBA.IntHolder;

import java.io.FileReader;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Chapter02 {

	@Test
	public void ex01() {
		LocalDate date = LocalDate.now().withDayOfMonth(1);
		int month = date.getMonthValue();

		System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
		DayOfWeek weekday = date.getDayOfWeek();

		int value = convertWeek(weekday.getValue());

		for (int i = 1; i < value; i++) {
			System.out.print("    ");
		}

		while (date.getMonthValue() == month) {
			System.out.printf("%4d", date.getDayOfMonth());
			date = date.plusDays(1);
			if (convertWeek(date.getDayOfWeek().getValue()) == 1) {
				System.out.println();
			}
		}
	}

	/**
	 * 요일 번호를 월요일(1)~일요일(7)에서 일요일(1)~토요일(7)으로 변경한다.
	 *
	 * @param value 요일 번호. 월요일(1) ~ 일요일(7)
	 * @return 요일 번호. 일요일(1) ~ 토요일(7)
	 */
	private int convertWeek(int value) {
		// 7 -> 1
		// 1 -> 2
		// 2 -> 3
		// 3 -> 4
		// 4 -> 5
		// 5 -> 6
		// 6 -> 7
		return value + 1 > 7 ? 1 : value + 1;
	}

	@Test
	public void ex02() {
		try (Scanner scanner = new Scanner(System.in);) {
			int nextInt = scanner.nextInt();
			System.out.println(nextInt);
		}

		Random r = new Random();
		r.nextInt(20);
	}

	@Test
	public void ex04() {
		IntHolder ih1 = new IntHolder(10);
		IntHolder ih2 = new IntHolder(20);
		System.out.println("ih1 = " + ih1.value + ", ih2 = " + ih2.value);

		// 교체
		int temp = ih1.value;
		ih1.value = ih2.value;
		ih2.value = temp;
		System.out.println("ih1 = " + ih1.value + ", ih2 = " + ih2.value);

		Integer i1 = new Integer(111);
		Integer i2 = new Integer(222);
		System.out.println("i1 = " + i1 + ", i2 = " + i2);

		Integer t = i1;
		i1 = i2;
		i2 = t;
		System.out.println("i1 = " + i1 + ", i2 = " + i2);
	}

	@Test
	public void ex05() {
		ch02.ex05.Point p = new ch02.ex05.Point(3, 4).translate(1, 3).scale(0.5);

		System.out.println(p.getX());
		System.out.println(p.getY());
	}

	@Test
	public void ex06() {
		ch02.ex06.Point p = new ch02.ex06.Point(3, 4).translate(1, 3).scale(0.5);

		System.out.println(p.getX());
		System.out.println(p.getY());
	}

	@Test
	public void ex10() {
		// ch02.ex10.RandomNumbers
		// ch02.ex10.MyArrayList
	}

	@Test
	public void ex11() {
		// ch02.ex11.Cal
	}

	@Test
	public void ex13() throws IOException {
		FileReader reader = new FileReader("docs/ch02/dump.csv");
		List<OsCpu> beans = new CsvToBeanBuilder<OsCpu>(reader).withType(OsCpu.class).build().parse();
		for (OsCpu bean : beans) {
			System.out.println(bean);
		}
	}

	@Test
	public void ex16() {
		ch02.ex16.Queue q = new ch02.ex16.Queue();
		q.add(new ch02.ex16.Queue.Node("a"));
		q.add(new ch02.ex16.Queue.Node("n"));
		q.add(new ch02.ex16.Queue.Node("t"));
		q.add(new ch02.ex16.Queue.Node("o"));
		q.add(new ch02.ex16.Queue.Node("p"));

		ch02.ex16.Queue.Node node = q.remove();

		System.out.println("removed node. " + node);
	}

	@Test
	public void ex17() {
		ch02.ex17.Queue q = new ch02.ex17.Queue();
		q.add(new ch02.ex17.Queue.Node("a"));
		q.add(new ch02.ex17.Queue.Node("n"));
		q.add(new ch02.ex17.Queue.Node("t"));
		q.add(new ch02.ex17.Queue.Node("o"));
		q.add(new ch02.ex17.Queue.Node("p"));

		Queue.Iterator iterator = q.getIterator();
		while (iterator.hasNext()) {
			ch02.ex17.Queue.Node node = iterator.next();

			System.out.println(node);
		}
	}


}
