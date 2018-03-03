package ch01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MagicSquare {

	public static void main(String[] args) {
		/*
		 * 입력
		 */
		List<String> inputs = new ArrayList<>();
		try (Scanner in = new Scanner(System.in);) {
			System.out.println("Input:");
			String line = null;
			while (true) {
				line = in.nextLine(); // 입력
				if ("".equals(line)) { // 아무것도 입력하지 않으면 끝
					break;
				}
				inputs.add(line.trim());
			}
		}

		/*
		 * 입력 검증 및 2차원 배열로 변환
		 */
		int size = inputs.size(); // 행의 크기(열의 크기)
		// 만들어질 2차원 배열
		int[][] square = new int[size][size];
		for (int rowIdx = 0; rowIdx < inputs.size(); rowIdx++) {
			String line = inputs.get(rowIdx);

			String[] column = line.split("\\s+");
			if (column.length != size) {
				// 행의 크기와 열의 크기가 다르면 에러
				System.err.println("잘못된 입력입니다.");
				System.exit(0);
			}

			for (int colIdx = 0; colIdx < column.length; colIdx++) {
				square[rowIdx][colIdx] = Integer.parseInt(column[colIdx]);
			}
		}

		/*
		 * 행, 열, 대각선의 합 검증
		 */
		List<Integer> sums = new ArrayList<>();
		// 행
		for (int rowIndex = 0; rowIndex < size; rowIndex++) {
			int sum = 0;
			for (int n : square[rowIndex]) {
				sum += n;
			}
			sums.add(sum);

			System.out.printf("행[%d] = %d\n", rowIndex, sum);
		}
		// 열
		for (int columnIndex = 0; columnIndex < size; columnIndex++) {
			int sum = 0;
			for (int rowIndex = 0; rowIndex < size; rowIndex++) {
				sum += square[rowIndex][columnIndex];
			}
			sums.add(sum);

			System.out.printf("열[%d] = %d\n", columnIndex, sum);
		}
		// 대각 1
		{
			int sum = 0;
			for (int i = 0; i < size; i++) {
				sum += square[i][i];
			}
			sums.add(sum);

			System.out.printf("대각1 = %d\n", sum);
		}
		// 대각 2
		{
			int sum = 0;
			for (int i = size - 1; i >= 0; i--) {
				sum += square[i][size - 1 - i];
			}
			sums.add(sum);

			System.out.printf("대각2 = %d\n", sum);
		}

		int sum = sums.get(0);
		for (int i = 1; i < sums.size(); i++) {
			if (sum != sums.get(i)) {
				System.err.println("매직 스퀘어가 아닙니다.");
				System.exit(0);
			}
		}

		System.out.println("매직 스퀘어!!!");

	}

}
