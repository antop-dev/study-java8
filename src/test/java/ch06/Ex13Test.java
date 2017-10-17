package ch06;

import ch06.ex12.Arrays;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Ex13Test {

	@Test
	public void test() {
		Random r = new Random();
		List<Integer> elements = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			elements.add(r.nextInt(100));
		}

		System.out.println("elements = " + elements);

		Comparator<Integer> comp = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		};

		List<Integer> result = new ArrayList<>();

		Arrays.maxmin(elements, comp, result);

		System.out.println("result = " + result);

	}

}
