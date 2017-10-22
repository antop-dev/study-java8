package ch07.ex05;

import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class Swaps {

	public static void swap(List<?> list, int i, int j) {
		if (list == null || i == j) {
			return;
		}

		if (i > list.size() || j > list.size()) {
			throw new IndexOutOfBoundsException("Size=" + list.size() + ", Index=" + i + ", " + j);
		}

		swapHelper(list, i, j);
	}

	private static <T> void swapHelper(List<T> list, int i, int j) {
		if (RandomAccess.class.isInstance(list)) {
			// random access
			Collections.swap(list, i, j);
		} else {
			swapNoRandomAccess(list, i, j);
		}

	}

	private static <T> void swapNoRandomAccess(List<T> list, int i, int j) {
		// 리스트의 가운데 인덱스 위치
		int half = list.size() >> 1;
		// 두 인덱스의 위치를 비교하여 순번을 정한다(첫번째, 두번째)
		int firstIndex = Integer.min(i, j);
		int secondIndex = Integer.max(i, j);

		T firstValue = null;
		T secondValue = null;
		int index = -1;

		if (firstIndex < half && secondIndex < half) { // 두개의 인덱스가 모두 절반 인덱스보다 앞에 있을 때
			ListIterator<T> iterator = list.listIterator(firstIndex - 1);

			do { // 맨 앞에서 뒤로 검색
				T o = iterator.next();
				// next() 메서드로 뒤로 이동할 때에 previsousIndex() 메서드가 현재 인덱스 위치를 나타낸다.
				index = iterator.previousIndex();

				if (index == firstIndex) { // 첫번째 값 찾음
					firstValue = o;
				}
				if (index == secondIndex) { // 두번째 값 찾음
					secondValue = o;
					iterator.set(firstValue); // 두번째 자리에 첫번째 값 치환
				}
			} while (index < secondIndex);

			do { // 다시 첫번째 값 위치로 앞으로 이동
				T o = iterator.previous();
				index = iterator.nextIndex();

				if (index == firstIndex) {
					iterator.set(secondValue); // 첫번째 자리에 두번째 값으로 치환
				}
			} while (index > firstIndex);
		} else if (firstIndex > half && secondIndex > half) { // 두개의 인덱스가 모두 절반 인덱스 보다 뒤에 있을 때
			ListIterator<T> iterator = list.listIterator(secondIndex + 1);

			do { // 맨 뒤에서 앞으로 검색
				T o = iterator.previous();
				// previous() 메서드로 뒤로 이동할 때에 nextIndex() 메서드가 현재 인덱스 위치를 나타낸다.
				index = iterator.nextIndex();

				if (index == secondIndex) { // 두번째 값 찾음
					firstValue = o;
				}
				if (index == firstIndex) { // 첫번째 값 참음
					secondValue = o;
					iterator.set(firstValue); // 첫번째 위치에 두번쨰 값으로 치환
				}
			} while (index > firstIndex);

			do { // 다시 두번째 값의 위치로 뒤로 이동
				T o = iterator.next();
				index = iterator.previousIndex();

				if (index == secondIndex) {
					// 두번째 자리에 첫번째 값으로 치환
					iterator.set(firstValue);
				}
			} while (index < secondIndex);
		} else { // 두개의 인덱스가 서로 떨어져 있을 경우
			Collections.swap(list, i, j);
		}
	}

}
