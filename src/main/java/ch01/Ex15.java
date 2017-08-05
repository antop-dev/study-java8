package ch01;

import java.util.ArrayList;
import java.util.List;

public class Ex15 {

	public static void main(String[] args) {
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

}
