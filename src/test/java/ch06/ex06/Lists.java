package ch06.ex06;

import java.util.List;

public class Lists {

	public static <E> void append1(List<? extends E> from, List<E> to) {
		to.addAll(from);
	}

	public static <E> void append2(List from, List<? super E> to) {
		to.addAll(from);
	}

}
