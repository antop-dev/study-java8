package ch06.ex15;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Lists {

	public static <E> List<E> map(List<E> list, Function<E, E> func) {
		List<E> result = new ArrayList<>();
		for(E e : list) {
			result.add(func.apply(e));
		}
		return result;
	}

}