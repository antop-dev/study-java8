package ch01;

public class Average {

	public int average(int number, int... numbers) {
		int sum = number;
		int count = numbers.length + 1;

		for (int n : numbers) {
			sum += n;
		}

		return sum / count;
	}

}
