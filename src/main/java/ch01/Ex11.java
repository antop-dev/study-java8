package ch01;

import java.util.Arrays;

public class Ex11 {

	public static void main(String[] args) {
		// 문자열
		String word = "Java™ 에서 유니코드를 처리합시다. Let's go!";
		System.out.println("string = " + word);
		// char[] 로 변환
		char[] chars = word.toCharArray();
		System.out.println(Arrays.toString(chars));

		// 아스키 코드를 제외하고 16진수 유니코드로 변환
		String[] unicode = new String[chars.length];
		for (int i = 0; i < chars.length; i++) {
			char c = chars[i];
			String s = String.valueOf(c);
			unicode[i] = c > 0 && c <= 127 ? s : String.format("\\u%04x", Integer.parseInt(Integer.toHexString(c), 16));
		}

		System.out.println(Arrays.toString(unicode));
	}

}
