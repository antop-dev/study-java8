package ch01;

public class Ex0302 {

	public static void main(String[] args) {
		// 정수 3개
		int n1 = 157;
		int n2 = 384;
		int n3 = 95;

		int max = Math.max(Math.max(n1, n2), n3);
		// 384
		System.out.println("max = " + max);
	}

}
