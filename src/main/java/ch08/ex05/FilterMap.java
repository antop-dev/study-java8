package ch08.ex05;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FilterMap {

	public static Stream<String> letters(String s) {
		return IntStream.rangeClosed(0, s.length() - 1).mapToObj(value -> s.substring(value, value + 1));
	}

}
