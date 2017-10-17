package ch06.ex02;

import java.util.Arrays;

public class Stack2<E> {

	private E[] array = (E[]) new Object[0];
	private int pos = -1;

	public void push(E e) {
		pos++;
		if (array.length == pos) {
			array = Arrays.copyOf(array, array.length + 1);
		}
		array[pos] = e;
	}

	public E pop() {
		if (isEmpty()) {
			return null;
		}
		E o = array[pos];
		array[pos] = null;
		pos--;
		return o;
	}

	public boolean isEmpty() {
		return pos < 0;
	}

	public static void main(String[] args) {
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
