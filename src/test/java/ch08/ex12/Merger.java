package ch08.ex12;

import java.util.Optional;
import java.util.stream.Stream;

public class Merger {

	public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
		Optional<T> reduce = first.reduce((t, t2) -> {
			System.out.println("--");
			System.out.println(t);
			System.out.println(t2);

			return t2;
		});

		return null;
	}

}
