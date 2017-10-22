package ch07.ex11;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Shuffle {

	public static void main(String[] args) {
		String line = "He has no earthly idea of whether he's coming or going";
		List<String> words = Arrays.asList(line.split("\\s+"));
		System.out.println(words);

		// shuffle
		Collections.shuffle(words.subList(1, words.size() - 1));
		System.out.println(words);
	}

}
