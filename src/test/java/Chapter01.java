import ch01.Average;
import org.junit.Test;

import java.math.BigInteger;
import java.util.*;

public class Chapter01 {

	@Test
	public void ex0101() {
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

	@Test
	public void ex0102() {
		double n = 2;
		// 역수
		double inverse = 1 / n;
		// 16진수 부동소수점
		String hex = Double.toHexString(inverse);

		System.out.println("n = " + n);
		System.out.println("inverse = " + inverse);
		System.out.println("hex = " + hex);
	}

	@Test
	public void ex02() {
		Random random = new Random();
		int y = 360; // 0 ~ 359

		int n = random.nextInt();
		System.out.println("n = " + n);

		int n1 = (n % y + y) % y;
		System.out.println("n1 = " + n1);

		int n2 = Math.floorMod(n, y);
		System.out.println("n2 = " + n2);
	}

	@Test
	public void ex0301() {
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

	@Test
	public void ex0302() {
		// 정수 3개
		int n1 = 157;
		int n2 = 384;
		int n3 = 95;

		int max = Math.max(Math.max(n1, n2), n3);
		// 384
		System.out.println("max = " + max);
	}

	@Test
	public void ex04() {
		double min = Math.nextUp(0);
		double max = Math.nextDown(Double.MAX_VALUE);

		System.out.println("min = " + min);
		System.out.println("max = " + max);
	}

	@Test
	public void ex05() {
		double d = Double.MAX_VALUE;
		int i = (int) d;

		System.out.println("double = " + d);
		System.out.println("integer = " + i);
	}

	@Test
	public void ex06() {
		// 반복 횟수
		int loop = 1000;

		for (int n = 1; n <= loop; n++) {
			BigInteger result = BigInteger.ONE;

			for (int j = 1; j <= n; j++) {
				result = result.multiply(BigInteger.valueOf(j));
			}

			System.out.println(n + "! = " + result);
		}
	}

	@Test
	public void ex08() {
		String s = "Slack brings all your communication together in one place. It's real-time messaging, archiving and search for modern teams.";
		System.out.println(s);

		String result = "";

		for (char c : s.toCharArray()) {
			if (c != ' ') {
				result += c;
			}
		}

		System.out.println(result);
	}

	@Test
	public void ex09() {
		String s1 = "antop";
		String s2 = "antop";
		String s3 = new String("antop");

		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
		System.out.println(s1 == s3);
		System.out.println(s1.equals(s3));
	}

	@Test
	public void ex10() {
		Random random = new Random();
		// long
		long n = random.nextLong();
		// to 36
		String conv = Long.toString(n, 36);

		System.out.println(n + " (16) to " + conv + " (36)");
	}

	@Test
	public void ex11() {
		// 문자열
		String word = "Java™ 에서 유니코드를 처리합시다. Let's go!";
		System.out.println("string = " + word);
		// char[] 로 변환
		char[] chars = word.toCharArray();
		System.out.println(Arrays.toString(chars));

		// 아스키 코드를 제외하고 16진수 유니코드로 변환
		String[] unicode = new String[chars.length];
		for (int i = 0; i < chars.length; i++) {
			char c = chars[i];
			String s = String.valueOf(c);
			unicode[i] = c > 0 && c <= 127 ? s : String.format("\\u%04x", Integer.parseInt(Integer.toHexString(c), 16));
		}

		System.out.println(Arrays.toString(unicode));
	}

	@Test
	public void ex13() {
		// 상자에 1부터 49까지 숫자를 채운다.
		List<Integer> box = new ArrayList<Integer>(49);
		for (int n = 1; n <= 49; n++) {
			box.add(n);
		}
		// 숫자를 뽑아 넣을 바구니
		List<Integer> basket = new ArrayList<Integer>(6);

		Random random = new Random();
		for (int i = 0; i < 6; i++) { // 6번 수행
			// 랜덤 위치
			int index = random.nextInt(box.size());
			// 상자에서 꺼냄
			int n = box.remove(index);
			// 바구니에 담음
			basket.add(n);
		}
		// 오름차순 정렬
		Collections.sort(basket);
		// 출력
		System.out.println("basket = " + basket);
	}

	@Test
	public void ex14() {
		// ch01.MagicSquare
	}

	@Test
	public void ex15() {
		// 횟수 (로우 수)
		int loop = 10;
		// 2차원 배열 리스트
		List<List<Integer>> triangle = new ArrayList<>();

		for (int i = 0; i < loop; i++) {
			List<Integer> row = new ArrayList<>();

			for (int j = 0; j <= i; j++) {
				// 기본값 1
				int n = 1;
				// 배열의 처음과 마지막이 아니면 계산
				if (j != 0 && j != i) {
					List<Integer> beforeRow = triangle.get(i - 1);
					n = beforeRow.get(j - 1) + beforeRow.get(j);
				}

				row.add(n);
			} // loop column

			triangle.add(row);
		} // loop row

		// 출력
		for (List<Integer> row : triangle) {
			System.out.println(row);
		}
	}

	@Test
	public void ex16() {
		Average average = new Average();
		int avg = average.average(10, 20, 40, 50);
		System.out.println("avg = " + avg);
	}


}
