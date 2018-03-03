import ch08.ex04.Random;
import ch08.ex05.FilterMap;
import ch08.ex06.StringStream;
import ch08.ex11.StreamUtils;
import ch08.ex12.Merger;
import org.apache.commons.lang3.time.StopWatch;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Chapter08 {

	private List<String> alice;
	private List<String> warandpeace;

	@Before
	public void before() throws IOException {
		String contents1 = new String(Files.readAllBytes(Paths.get("docs/ch08/alice.txt")));
		alice = Arrays.asList(contents1.split("\\PL+"));

		String contents2 = new String(Files.readAllBytes(Paths.get("docs/ch08/warandpeace.txt")));
		warandpeace = Arrays.asList(contents2.split("\\PL+"));
	}

	@Test
	public void ex01() {
		List<String> result = warandpeace.stream().peek(s -> System.out.println("peak = " + s)).filter(s -> s.length() > 12).limit(5).collect(Collectors.toList());
		System.out.println("result = " + result);
	}

	@Test
	public void ex02() {
		// using commons-lang3
		StopWatch stopwatch = new StopWatch();

		stopwatch.reset();
		stopwatch.start();
		long c1 = warandpeace.stream().filter(s -> s.length() > 12).count();
		stopwatch.stop();
		System.out.println("stream = " + stopwatch.toString());

		stopwatch.reset();
		stopwatch.start();
		long c2 = warandpeace.parallelStream().filter(s -> s.length() > 12).count();
		stopwatch.stop();
		System.out.println("parallelStream = " + stopwatch.toString());
	}

	@Test
	public void ex03() {
		int[] values = {1, 4, 9, 16};
		IntStream stream = IntStream.of(values);
	}

	@Test
	public void ex04() {
		Stream<Long> stream = Random.get(10, 2521490397L, 11, (long) Math.pow(2, 48)).limit(10);

		Iterator<Long> iterator = stream.iterator();
		while (iterator.hasNext()) {
			Long l = iterator.next();
			System.out.println("l = " + l);
		}

	}

	@Test
	public void ex05() {
		Stream<String> letters = FilterMap.letters("boat");
		System.out.println(Arrays.toString(letters.toArray()));
	}

	@Test
	public void ex06() {
		boolean bool = StringStream.isWord("antop");
		System.out.println("bool = " + bool);
	}

	@Test
	public void ex07() throws IOException {
		// filter word
		Stream<String> filtered = warandpeace.stream().filter(s -> StringStream.isWord(s));
		// to lower case
		Stream<String> toLowerCase = filtered.map(String::toLowerCase);
		// grouping (word :: counting)
		Map<String, Long> grouping = toLowerCase.collect(Collectors.groupingBy(String::new, Collectors.counting()));
		// map -> stream -> sort
		Stream<Map.Entry<String, Long>> sorted = grouping.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed()).limit(10);
		// print
		sorted.forEach(System.out::println);
	}

	@Test
	public void ex08() {

	}

	@Test
	public void ex09() {
		OptionalDouble average = warandpeace.stream().mapToInt(value -> value.length()).average();
		average.ifPresent(value -> System.out.println("average = " + (int) value));
	}

	@Test
	public void ex10() {
		// grouping (length :: list)
		Map<Integer, List<String>> grouping = alice.stream().collect(Collectors.groupingBy(String::length));
		// get max length
		Optional<Map.Entry<Integer, List<String>>> max = grouping.entrySet().stream().collect(Collectors.maxBy(Map.Entry.comparingByKey()));
		// print
		max.ifPresent(e -> System.out.println(e.getValue()));
	}

	@Test
	public void ex11() {
		Stream<Double> stream = Stream.generate(() -> Math.random());
		boolean bool = StreamUtils.isFinite(stream);
		System.out.println("isFinite = " + bool);
	}

	@Test
	public void ex12() {
		Stream<String> s1 = alice.stream().skip(100).limit(12);
		Stream<String> s2 = warandpeace.stream().skip(100).limit(10);

		Stream<String> zip = Merger.zip(s1, s2);
		//zip.forEachOrdered(System.out::println);
	}

	@Test
	public void ext13() {
		ArrayList<String> list1 = new ArrayList<>(Arrays.asList("a", "b", "c"));
		ArrayList<String> list2 = new ArrayList<>(Arrays.asList("d", "e", "f"));
		ArrayList<String> list3 = new ArrayList<>(Arrays.asList("g", "h", "i"));
		ArrayList<String> list4 = new ArrayList<>(Arrays.asList("j", "k", "l"));
		ArrayList<String> list5 = new ArrayList<>(Arrays.asList("m", "n", "o"));
		Stream<ArrayList<String>> stream = Stream.of(list1, list2, list3, list4, list5);

		/*
		Optional<ArrayList<String>> reduce = stream.reduce((x, y) -> {
			System.out.println("x = " + x + ", y = " + y);
			ArrayList<String> list = new ArrayList<>();
			list.addAll(x);
			list.addAll(y);
			return list;
		});

		reduce.ifPresent(v -> System.out.println("result = " + v));
		System.out.println("list1 = " + list1);
		*/

		/*
		ArrayList<String> reduce = stream.reduce(new ArrayList<String>(), (x, y) -> {
			x.addAll(y);
			return x;
		});

		System.out.println("result = " + reduce);
		*/


		ArrayList<String> reduce = stream.parallel().reduce(new ArrayList<String>(), (x, y) -> {
			System.out.println("accumulator = " + Thread.currentThread().getName() + ", x = " + x + ", y = " + y);

			ArrayList<String> accumulator = new ArrayList<>();
			accumulator.addAll(x);
			accumulator.addAll(y);
			return accumulator;
		}, (x, y) -> {
			System.out.println("combiner = " + Thread.currentThread().getName() + ", x = " + x + ", y = " + y);

			ArrayList<String> combiner = new ArrayList<>();
			combiner.addAll(x);
			combiner.addAll(y);
			return combiner;
		});

		System.out.println("result = " + reduce);
	}

	@Test
	public void ex14() {
		Stream<Double> stream = Stream.generate(() -> Math.random()).limit(20);

		Optional<Double> reduce = stream.reduce(Double::sum);
		reduce.ifPresent(d -> System.out.println(d / stream.count()));
	}

	@Test
	public void ex15() {

	}

	@Test
	public void ex16() {
		StopWatch stopwatch = new StopWatch();

		stopwatch.reset();
		stopwatch.start();
		warandpeace.stream().sorted(Comparator.comparing(String::length).reversed()).limit(500).count();
		stopwatch.stop();
		System.out.println("stream = " + stopwatch.toString());

		stopwatch.reset();
		stopwatch.start();
		warandpeace.parallelStream().sorted(Comparator.comparing(String::length).reversed()).limit(500).count();
		stopwatch.stop();
		System.out.println("parallelStream = " + stopwatch.toString());
	}

	@Test
	public void test() {
		System.out.println("Length is "
				+ Stream.generate(Math::random)
				.spliterator()
				.estimateSize());

		System.out.println(Long.MAX_VALUE);

	}

}
