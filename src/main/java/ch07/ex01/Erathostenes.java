package ch07.ex01;

import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Erathostenes {

	public static void main(String[] args) {
		int numbers = 100;
		Set<Integer> set = new HashSet<>();
		for (int i = 2; i <= numbers; i++) {
			set.add(i);
		}

		while (true) {
			int n = Collections.min(set);
			set.removeIf(integer -> integer % n == 0);
			if (Math.pow(n, 2) > numbers) {
				break;
			}
		}

		System.out.println(set);
	}

}
