package ch06;

import ch06.ex01.Stack;
import org.junit.Test;

public class Ex01Test {

	@Test
	public void test() {
		Stack<String> s = new Stack<>();
		s.push("a");
		s.push("b");

		System.out.println("pop = " + s.pop());
		s.push("c");
		s.push("d");
		System.out.println("pop = " + s.pop());
		System.out.println("pop = " + s.pop());
		System.out.println("pop = " + s.pop());
		System.out.println("pop = " + s.pop());
		System.out.println("pop = " + s.pop());
	}

}
