package ch07.ex02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ToUpperA {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");

		ListIterator<String> iter = list.listIterator();
		while (iter.hasNext()) {
			String s = iter.next();
			iter.set(s.toUpperCase());
		}

		System.out.println("-- result --");
		System.out.println("size = " + list.size());
		for(String s : list) {
			System.out.println("s = " + s);
		}
	}

}
