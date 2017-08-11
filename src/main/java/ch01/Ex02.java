package ch01;

import java.util.Random;

public class Ex02 {

	public static void main(String[] args) {
		Random random = new Random();
		int y = 360; // 0 ~ 359

		int n = random.nextInt();
		System.out.println("n = " + n);

		int n1 = (n % y + y) % y;
		System.out.println("n1 = " + n1);

		int n2 = Math.floorMod(n, y);
		System.out.println("n2 = " + n2);
	}

}
