package ch06;

import ch06.ex07.Pair;
import ch06.ex11.Arrays;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

public class Ex11Test {

	@Test
	public void test() {
		Random r = new Random();

		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			int n = r.nextInt(100);
			list.add(n);
		}

		System.out.println(list);

		Pair<Integer> pair = Arrays.minMax(list);

		System.out.println("left = " + pair.getLeft());
		System.out.println("right = " + pair.getRight());
	}

}
