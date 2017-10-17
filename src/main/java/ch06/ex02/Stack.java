package ch06.ex02;

import java.util.Arrays;

public class Stack<E> {
	private Object[] array = new Object[0];
	// 마지막 데이터가 들어있는 위치를 가리키는 포인터
	private int pos = -1;

	public void push(E e) {
		pos++;
		if (array.length == pos) {
			// 배열 크기 증가
			array = Arrays.copyOf(array, array.length + 1);
		}
		array[pos] = e;
	}

	public E pop() {
		if (isEmpty()) {
			return null;
		}
		Object o = array[pos];
		array[pos] = null;
		pos--;
		return (E) o; // 형변환
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