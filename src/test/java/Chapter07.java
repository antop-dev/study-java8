import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.UnaryOperator;

public class Chapter07 {

	private Random random;

	@Before
	public void before() {
		random = new Random();
	}

	@Test
	public void ex01() {
		int numbers = 100;
		Set<Integer> set = new HashSet<>();
		for (int i = 2; i <= numbers; i++) {
			set.add(i);
		}

		while (true) {
			int n = Collections.min(set);
			set.removeIf(integer -> integer % n == 0);
			if (Math.pow(n, 2) > numbers) {
				break;
			}
		}

		System.out.println(set);
	}

	@Test
	public void ex02a() {
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

	@Test
	public void ex02b() {
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

	@Test
	public void ex02c() {
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");

		list.replaceAll(s -> s.toUpperCase());

		System.out.println("-- result --");
		System.out.println("size = " + list.size());
		for(String s : list) {
			System.out.println("s = " + s);
		}
	}

	@Test
	public void ex03() {
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

	@Test
	public void ex05() {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 1_000_000; i++) {
			list.add(random.nextInt(1000));
		}

		int i = random.nextInt(1_000_000);
		int j = random.nextInt(1_000_000);

		System.out.println("swap " + i + " ↔ " + j);
		long start = System.nanoTime();
		ch07.ex05.Swaps.swap(list, i, j);
		long end = System.nanoTime();
		System.out.println("not swap api elapsed time = " + (end - start));
	}

	@Test
	public void ex07() throws IOException {
		BufferedReader reader = Files.newBufferedReader(Paths.get("docs/ch07/cnn.txt"));
		Map<String, Integer> counts = new TreeMap<>();

		String line = null;
		while((line = reader.readLine()) != null) {
			String[] split = line.split("\\s+");
			for (String word : split) {
				counts.merge(word, 1, (i1, i2) -> Integer.sum(i1, i2));
			}
		}

		System.out.println("-- result --");
		for (Map.Entry<String, Integer> entry : counts.entrySet()) {
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}
	}

	@Test
	public void ex08() throws IOException {
		BufferedReader reader = Files.newBufferedReader(Paths.get("docs/ch07/cnn.txt"));
		Map<String, Set<Integer>> map = new TreeMap<>();

		String line = null;
		for (int lineCount = 1 ; (line = reader.readLine()) != null ; lineCount++) {
			String[] split = line.split("\\s+");
			for (String word : split) {
				Set<Integer> set = map.get(word);
				if (set == null) {
					set = new TreeSet<>();
					map.put(word, set);
				}

				set.add(lineCount);
			}
		}

		System.out.println("-- result --");
		for (Map.Entry<String, Set<Integer>> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}
	}

	@Test
	public void ex11() {
		String line = "He has no earthly idea of whether he's coming or going";
		List<String> words = Arrays.asList(line.split("\\s+"));
		System.out.println(words);

		// shuffle
		Collections.shuffle(words.subList(1, words.size() - 1));
		System.out.println(words);
	}

	@Test
	public void ex13() {
		ch07.ex13.Cache<String, Integer> cache = new ch07.ex13.Cache<>(5);
		cache.put("key1", random.nextInt(100));
		cache.put("key2", random.nextInt(100));
		cache.put("key3", random.nextInt(100));
		cache.put("key4", random.nextInt(100));
		cache.put("key5", random.nextInt(100));
		cache.put("key6", random.nextInt(100));
		cache.put("key7", random.nextInt(100));
		cache.put("key8", random.nextInt(100));
		cache.put("key9", random.nextInt(100));
		cache.put("key10", random.nextInt(100));

		for (Map.Entry<String, Integer> entry : cache.entrySet()) {
			System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
		}
	}

}
