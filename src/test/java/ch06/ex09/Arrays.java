package ch06.ex09;

import ch06.ex07.Pair;

import java.util.ArrayList;

public class Arrays {

	public static <E> Pair<E> firstLast(ArrayList<? extends Comparable> list) {
		if (list == null || list.size() == 0) {
			return null;
		}

		E first = (E) list.get(0);
		E last = (E) list.get(list.size() - 1);

		Pair<E> pair = new Pair<>(first, last);
		return pair;
	}

}
