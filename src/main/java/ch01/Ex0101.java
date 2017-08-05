package ch01;

public class Ex0101 {

	public static void main(String[] args) {
		// 정수
		int n = 200;
		// 2진수
		String binary = Integer.toBinaryString(n);
		// 8진수
		String octal = Integer.toOctalString(n);
		// 16진수
		String hex = Integer.toHexString(n);

		System.out.println("binary = " + binary);
		System.out.println("octal = " + octal);
		System.out.println("hex = " + hex);
	}

}
