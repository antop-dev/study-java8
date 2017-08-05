package ch01;

public class Ex0301 {

	public static void main(String[] args) {
		// 정수 3개
		int n1 = 12;
		int n2 = 9;
		int n3 = 17;

		int max = Integer.MIN_VALUE;
		if (n1 > max) {
			max = n1;
		}
		if (n2 > max) {
			max = n2;
		}
		if (n3 > max) {
			max = n3;
		}
		// 17
		System.out.println("max = " + max);
	}

}
