package ch06.ex10;

import java.util.ArrayList;

public class Arrays {

	public static <E> E min(ArrayList<? extends Comparable> list) {
		E min = null;
		for (Comparable o : list) {
			if (min == null || o.compareTo(min) < 0) {
				min = (E) o;
			}
		}
		return min;
	}

	public static <E> E max(ArrayList<? extends Comparable> list) {
		E max = null;
		for (Comparable o : list) {
			if (max == null || o.compareTo(max) > 0) {
				max = (E) o;
			}
		}
		return max;
	}

}
