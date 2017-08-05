package ch01;

public class Ex0102 {

	public static void main(String[] args) {
		double n = 2;
		// 역수
		double inverse = 1 / n;
		// 16진수 부동소수점
		String hex = Double.toHexString(inverse);

		System.out.println("n = " + n);
		System.out.println("inverse = " + inverse);
		System.out.println("hex = " + hex);
	}

}
