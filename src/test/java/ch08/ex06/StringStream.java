package ch08.ex06;

public class StringStream {

	public static boolean isWord(String s) {
		return s.codePoints().allMatch(value -> Character.isAlphabetic(value));
	}

}
