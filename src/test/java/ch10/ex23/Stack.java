package ch10.ex23;

import java.util.Arrays;

public class Stack {

	private Object[] values = new Object[10];
	private int size;

	public void push(Object newValue) {
		synchronized (values) {
			if (size == values.length) {
				values = Arrays.copyOf(values, 2 * size);
			}
			values[size] = newValue;
			size++;
		}
	}

}
