package ch06;

import ch06.ex05.Arrays;
import org.junit.Test;

public class Ex05Test {

	@Test
	public void test() {
		Double[] result = Arrays.<Double>swap(0, 1, 11.5, 2D, 3D);
		System.out.println(java.util.Arrays.toString(result));

	}

}
