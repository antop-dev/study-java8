package ch07.ex02;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ToUpperB {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");

		for (int i = list.size() - 1; i >= 0; i--) {
			String s = list.get(i);
			list.set(i, s.toUpperCase());
		}

		System.out.println("-- result --");
		System.out.println("size = " + list.size());
		for(String s : list) {
			System.out.println("s = " + s);
		}
	}

}
