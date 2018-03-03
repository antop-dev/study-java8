package ch06.ex11;

import ch06.ex07.Pair;

import java.util.ArrayList;

public class Arrays {

	public static <E> Pair<E> minMax(ArrayList<? extends Comparable> list) {
		E first = null;
		E last = null;

		for (Comparable o: list) {
			if (first == null || o.compareTo(first) < 0) {
				first = (E) o;
			}
			if (last == null || o.compareTo(last) > 0) {
				last = (E) o;
			}
		}

		Pair<E> pair = new Pair<>(first, last);
		return pair;
	}

}