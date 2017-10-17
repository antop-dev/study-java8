package ch06;

import ch06.ex08.Pair;
import ch06.sec04.Employee;
import org.junit.Test;

public class Ex08Test {

	@Test
	public void test01() {
		Pair<Integer> pair = new Pair<>(1, 2);

		Integer min = pair.getMin();
		Integer max = pair.getMax();

		System.out.println("min = " + min);
		System.out.println("max = " + max);
	}

	@Test
	public void test02() {
		Pair<String> pair = new Pair<>("antop", "java");

		String min = pair.getMin();
		String max = pair.getMax();

		System.out.println("min = " + min);
		System.out.println("max = " + max);
	}

}
