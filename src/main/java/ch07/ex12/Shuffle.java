package ch07.ex12;

import java.util.Arrays;
import java.util.List;

public class Shuffle {

	public static void main(String[] args) {
		String line = "How it beat the odds.";
		List<String> words = Arrays.asList(line.split("\\s+"));
		System.out.println(words);


	}

}
