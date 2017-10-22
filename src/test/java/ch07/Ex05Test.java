package ch07;

import ch07.ex05.Swaps;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Ex05Test {

	private int SIZE = 1_000_000;
	private Random random;

	@Before
	public void before() {
		random = new Random();
	}

	@Test
	public void test01() {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < SIZE; i++) {
			list.add(random.nextInt(1000));
		}

		int i = random.nextInt(SIZE);
		int j = random.nextInt(SIZE);

		System.out.println("swap " + i + " ↔ " + j);
		long start = System.nanoTime();
		Swaps.swap(list, i, j);
		long end = System.nanoTime();
		System.out.println("not swap api elapsed time = " + (end - start));
	}

	@Test
	public void test02() {
		List<Integer> list1 = new LinkedList<>();
		List<Integer> list2 = new LinkedList<>();

		for (int l = 0; l < SIZE; l++) {
			int v = random.nextInt(1000);
			list1.add(v);
			list2.add(v);
		}


	}
}
