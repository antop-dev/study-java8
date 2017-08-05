package ch01;

import java.math.BigInteger;

public class Ex06 {

	public static void main(String[] args) {
		// 반복 횟수
		int loop = 1000;

		for (int n = 1 ; n <= loop ; n++) {
			BigInteger result = BigInteger.ONE;

			for (int j = 1 ; j <= n ; j++) {
				result = result.multiply(BigInteger.valueOf(j));
			}

			System.out.println(n + "! = " + result);
		}

	}

}
