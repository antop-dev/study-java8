package ch06.ex01;

import java.util.ArrayList;
import java.util.List;

public class Stack<E> {

	private List<E> list = new ArrayList<>();

	public void push(E e) {
		list.add(e);
	}

	public E pop() {
		if (isEmpty()) {
			return null;
		}
		return list.remove(list.size() - 1);
	}

	public boolean isEmpty() {
		// return list.isEmpty();
		return list.size() == 0;
	}

}
