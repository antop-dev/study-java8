package ch07.ex02;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class ToUpperC {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");

		list.replaceAll(new UnaryOperator<String>() {
			@Override
			public String apply(String s) {
				return s.toUpperCase();
			}
		});

		// list.replaceAll(s -> s.toUpperCase());

		System.out.println("-- result --");
		System.out.println("size = " + list.size());
		for(String s : list) {
			System.out.println("s = " + s);
		}
	}

}
