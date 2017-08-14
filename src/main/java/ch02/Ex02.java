package ch02;

import java.util.Random;
import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in);) {
			int nextInt = scanner.nextInt();
			System.out.println(nextInt);
		}

		Random r = new Random();
		r.nextInt(20);
	}

}