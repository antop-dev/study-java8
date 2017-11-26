package ch08.ex11;

import java.util.stream.Stream;

public class StreamUtils {

	public static <T> boolean isFinite(Stream<T> stream) {
		return stream.spliterator().estimateSize() != Long.MAX_VALUE;
	}

}
