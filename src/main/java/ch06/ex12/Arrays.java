package ch06.ex12;

import ch06.sec04.Lists;

import java.util.Comparator;
import java.util.List;

public class Arrays {

	public static <T> void minmax(List<T> elements, Comparator<? super T> comp, List<? super T> result) {
		T min = null;
		T max = null;

		for (T ele : elements) {
			if (min == null || comp.compare(ele, min) < 0) {
				min = ele;
			}
			if (max == null || comp.compare(ele, max) > 0) {
				max = ele;
			}
		}

		result.add(min);
		result.add(max);
	}

	public static <T> void maxmin(List<T> elements, Comparator<? super T>comp, List<? super T> result) {
		minmax(elements, comp, result);
		Lists.swap(result, 0, 1);
	}
}
