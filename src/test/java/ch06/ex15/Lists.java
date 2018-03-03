package ch06.ex15;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Lists {

	public static <T, R> List<R> map(List<T> list, Function<T, R> func) {
		List<R> result = new ArrayList<>();
		for(T e : list) {
			result.add(func.apply(e));
		}
		return result;
	}

}