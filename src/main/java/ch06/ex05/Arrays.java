package ch06.ex05;

public class Arrays {

	public static <T extends Double> T[] swap(int i, int j, T... values) {
		T temp = values[i];
		values[i] = values[j];
		values[j] = temp;
		return values;
	}

}
