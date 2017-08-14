package ch02.ex10;

import java.util.ArrayList;
import java.util.Random;

public class RandomNumbers {

	private static final Random r = new Random();

	public static int randomElement(int[] array) {
		ArrayList<Integer> list = new ArrayList<>(array.length);
		for (int i : array) {
			list.add(i);
		}

		return randomElement(list);
	}

	public static int randomElement(ArrayList<Integer> list) {
		if (list == null || list.isEmpty()) {
			return 0;
		}

		return list.get(r.nextInt(list.size()));
	}

}