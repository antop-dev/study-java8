package ch01;

public class Ex16 {

	public int average(int number, int... numbers) {
		int sum = number;
		int count = numbers.length + 1;

		for (int n : numbers) {
			sum += n;
		}

		return sum / count;
	}

	public static void main(String[] args) {
		Ex16 e = new Ex16();

		int avg = e.average(10, 20, 40, 50);
		System.out.println("avg = " + avg);
	}

}
