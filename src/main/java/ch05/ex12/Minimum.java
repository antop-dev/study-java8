package ch05.ex12;

import java.util.Random;

public class Minimum {

	public int min(int[] values) {
		int min = Integer.MAX_VALUE;
		for (int v : values) {
			if (v < min) {
				min = v;
			}
		}

		assert validate(values, min) : min + " is not min value";

		return min;
	}

	private boolean validate(int[] values, int min) {
		for (int v : values) {
			if (min > v) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Minimum o = new Minimum();

		Random r = new Random();
		int size = 120_000_000;
		System.out.println("size = " + size);

		int[] values = new int[size];
		for (int i = 0; i < size; i++) {
			values[i] = java.lang.Math.abs(r.nextInt());
		}

		long start = System.currentTimeMillis();
		int min = o.min(values);
		long end = System.currentTimeMillis();

		System.out.println("min = " + min);
		System.out.println("time = " + (end - start) + "ms");
	}

}
