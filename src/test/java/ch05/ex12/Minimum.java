package ch05.ex12;

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

}
