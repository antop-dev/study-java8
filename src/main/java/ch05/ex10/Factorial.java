package ch05.ex10;

import java.math.BigInteger;

public class Factorial {

	public BigInteger factorial(int loop) {
		return factorial(BigInteger.ONE, 1, loop);
	}

	private BigInteger factorial(BigInteger n, int c, int loop) {
		n = n.multiply(BigInteger.valueOf(c));
		if (c < loop) {
			n = factorial(n, ++c, loop);
		}
		return n;
	}

	public static void main(String[] args) {
		Factorial f = new Factorial();

		try {
			BigInteger n = f.factorial(10);
			System.out.println("n = " + n);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
