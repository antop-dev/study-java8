package ch02.ex10;

import java.util.ArrayList;
import java.util.Random;

public class MyArrayList<E> extends ArrayList<E> {

	private static final long serialVersionUID = 8966542342016062367L;

	private final Random r = new Random();
	
	/**
	 * 임의의 요소를 얻는다.
	 * @return
	 */
	public E randomElement() {
		if (isEmpty()) {
			return null;
		}
		
		return get(r.nextInt(size()));
	}
	
}
