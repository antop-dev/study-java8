package ch06;

import ch06.ex02.Stack;
import ch06.ex02.Stack2;
import org.junit.Test;

public class Ex02Test {

	@Test
	public void test1() {
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

	@Test
	public void test2() {
		Stack2<String> s = new Stack2<>();
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
