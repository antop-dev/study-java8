package ch06;

import ch06.ex06.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Ex06Test {

	@Test
	public void test01() {
		List<String> from = new ArrayList<>();
		from.add("a");
		from.add("b");

		List<String> to = new ArrayList<>();
		to.add("c");
		to.add("d");

		Lists.append1(from, to);

		for (String s : to) {
			System.out.println("s = " + s);
		}
	}

	@Test
	public void test02() {
		List<String> from = new ArrayList<>();
		from.add("a");
		from.add("b");

		List<String> to = new ArrayList<>();
		to.add("c");
		to.add("d");

		Lists.append2(from, to);

		for (String s : to) {
			System.out.println("s = " + s);
		}
	}

}
