package ch07.ex04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConcurrentModificationExceptionDemo {

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		list.add("f");
		list.add("g");

		List<String> newList = Collections.synchronizedList(list);

		for (String s : newList) {
			newList.add("222");
		}

	}

}
