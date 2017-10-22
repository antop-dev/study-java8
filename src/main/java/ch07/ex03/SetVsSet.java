package ch07.ex03;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SetVsSet {

	public static void main(String[] args) {
		Set<String> set1 = new HashSet<>();
		set1.add("a");
		set1.add("b");
		set1.add("c");
		set1.add("d");
		set1.add("e");

		Set<String> set2 = new HashSet<>();
		set2.add("d");
		set2.add("e");
		set2.add("f");
		set2.add("g");
		set2.add("h");

		// 교집합
		Set<String> intersection = new HashSet<>(set1);
		intersection.retainAll(set2);
		// 합집합
		Set<String> union = new HashSet<>(set1);
		union.addAll(set2);
		// 차집합(set1 - set2)
		Set<String> dos1 = new HashSet<>(set1);
		dos1.removeAll(set2);
		// 차집합(set2 - set1)
		Set<String> dos2 = new HashSet<>(set2);
		dos2.removeAll(set1);

		System.out.println("intersection = " + intersection);
		System.out.println("universal set = " + union);
		System.out.println("difference of set1 = " + dos1);
		System.out.println("difference of set2 = " + dos2);
	}

}
