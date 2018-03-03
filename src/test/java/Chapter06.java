import org.junit.Test;

import java.util.*;

public class Chapter06 {

	@Test
	public void ex01() {
		ch06.ex01.Stack<String> s = new ch06.ex01.Stack<>();
		s.push("a");
		s.push("b");

		System.out.println("pop = " + s.pop());
		s.push("c");
		s.push("d");
		System.out.println("pop = " + s.pop());
		System.out.println("pop = " + s.pop());
		System.out.println("pop = " + s.pop());
		System.out.println("pop = " + s.pop());
		System.out.println("pop = " + s.pop());
	}

	@Test
	public void ex0201() {
		ch06.ex02.Stack1<String> s = new ch06.ex02.Stack1<>();
		s.push("a");
		s.push("b");

		System.out.println("pop = " + s.pop());
		s.push("c");
		s.push("d");
		System.out.println("pop = " + s.pop());
		System.out.println("pop = " + s.pop());
		System.out.println("pop = " + s.pop());
		System.out.println("pop = " + s.pop());
		System.out.println("pop = " + s.pop());
	}

	@Test
	public void ex0202() {
		ch06.ex02.Stack2<String> s = new ch06.ex02.Stack2<>();
		s.push("a");
		s.push("b");

		System.out.println("pop = " + s.pop());
		s.push("c");
		s.push("d");
		System.out.println("pop = " + s.pop());
		System.out.println("pop = " + s.pop());
		System.out.println("pop = " + s.pop());
		System.out.println("pop = " + s.pop());
		System.out.println("pop = " + s.pop());
	}

	@Test
	public void ex03() {
		ch06.ex03.Table<String, Integer> table = new ch06.ex03.Table<>();
		table.put("a", 1);
		table.put("b", 2);
		table.put("c", 4);
		table.put("d", 7);
		table.put("e", 8);

		System.out.println("get = " + table.get("a"));
		System.out.println("get = " + table.get("a"));

		table.remove("b");

		System.out.println("get = " + table.get("b"));
	}

	@Test
	public void ex04() {
		ch06.ex04.Table<String, Integer> table = new ch06.ex04.Table<>();
		table.put("a", 1);
		table.put("b", 2);
		table.put("c", 4);
		table.put("d", 7);
		table.put("e", 8);

		System.out.println("get = " + table.get("a"));
		System.out.println("get = " + table.get("a"));

		table.remove("b");

		System.out.println("get = " + table.get("b"));
	}

	@Test
	public void ex05() {
		Double[] result = ch06.ex05.Arrays.<Double>swap(0, 1, 11.5, 2D, 3D);
		System.out.println(java.util.Arrays.toString(result));
	}


	@Test
	public void ex0601() {
		List<String> from = new ArrayList<>();
		from.add("a");
		from.add("b");

		List<String> to = new ArrayList<>();
		to.add("c");
		to.add("d");

		ch06.ex06.Lists.append1(from, to);

		for (String s : to) {
			System.out.println("s = " + s);
		}
	}

	@Test
	public void ex0602() {
		List<String> from = new ArrayList<>();
		from.add("a");
		from.add("b");

		List<String> to = new ArrayList<>();
		to.add("c");
		to.add("d");

		ch06.ex06.Lists.append2(from, to);

		for (String s : to) {
			System.out.println("s = " + s);
		}
	}

	@Test
	public void ex07() {
		// ch06.ex07.Pair
	}

	@Test
	public void ex0801() {
		ch06.ex08.Pair<Integer> pair = new ch06.ex08.Pair<>(1, 2);

		Integer min = pair.getMin();
		Integer max = pair.getMax();

		System.out.println("min = " + min);
		System.out.println("max = " + max);
	}

	@Test
	public void ex0802() {
		ch06.ex08.Pair<String> pair = new ch06.ex08.Pair<>("antop", "java");

		String min = pair.getMin();
		String max = pair.getMax();

		System.out.println("min = " + min);
		System.out.println("max = " + max);
	}

	@Test
	public void ex09() {
		Random r = new Random();

		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			int n = r.nextInt(100);
			list.add(n);
		}

		System.out.println(list);

		ch06.ex07.Pair<Integer> pair = ch06.ex09.Arrays.firstLast(list);

		System.out.println("first = " + pair.getLeft());
		System.out.println("last = " + pair.getRight());
	}

	@Test
	public void ex10() {
		Random r = new Random();

		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			int n = r.nextInt(100);
			list.add(n);
		}

		System.out.println(list);

		Integer min = ch06.ex10.Arrays.min(list);
		System.out.println("min = " + min);

		Integer max = ch06.ex10.Arrays.max(list);
		System.out.println("max = " + max);
	}

	@Test
	public void ex11() {
		Random r = new Random();

		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			int n = r.nextInt(100);
			list.add(n);
		}

		System.out.println(list);

		ch06.ex07.Pair<Integer> pair = ch06.ex11.Arrays.minMax(list);

		System.out.println("min = " + pair.getLeft());
		System.out.println("max = " + pair.getRight());
	}

	@Test
	public void ex12() {
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

		ch06.ex12.Arrays.minmax(elements, comp, result);

		System.out.println("result = " + result);
	}

	@Test
	public void ex15() {
		List<String> in = Arrays.asList("elements", "result", "java");
		System.out.println("in = " + in);

		List<Integer> out = ch06.ex15.Lists.map(in, (v) -> v.length());
		System.out.println("out = " + out);
	}

	@Test
	public void ex17() {
		// ch06.ex17.Employee
	}

	@Test
	public void ex18() {
		Double[] repeat = ch06.ex18.Arrays.repeat(10, 42D, Double[]::new);
	}

}
