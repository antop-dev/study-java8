package ch01;

import java.util.Random;

public class Ex10 {

	public static void main(String[] args) {
		Random random = new Random();
		// long
		long n = random.nextLong();
		// to 36
		String conv = Long.toString(n, 36);

		System.out.println(n + " (16) to " + conv + " (36)");
	}

}
