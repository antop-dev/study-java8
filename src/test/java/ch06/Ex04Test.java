package ch06;

import ch06.ex04.Table;
import org.junit.Test;

public class Ex04Test {

	@Test
	public void test() {
		Table<String, Integer> table = new Table<>();
		table.put("a", 1);
		table.put("b", 2);
		table.put("c", 4);
		table.put("d", 7);
		table.put("e", 8);

		System.out.println("get = " + table.get("a"));
		System.out.println("get = " + table.get("a"));

		table.remove("b");

		System.out.println("get = " + table.get("b"));
	}

}
