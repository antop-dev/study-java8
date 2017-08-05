package ch01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Ex13 {

	public static void main(String[] args) {
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

}
