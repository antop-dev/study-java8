package ch08.ex04;

import java.util.stream.Stream;

public class Random {

	public static Stream<Long> get(long seed, long a, long c, long m) {
		return Stream.iterate(seed, x -> (a * x + c) % m);
	}

}
