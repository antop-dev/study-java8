#### 1. 긴 단어 처음 다섯 개를 요청했을 때 일단 다섯 번째 긴 단어를 발견하고 나면 filter 메서드를 호출하지 않음을 확인하라. 간단하게 각 메서드 호출을 기록하라.

```java
List<String> result = words.stream().peek(s -> System.out.println("peak = " + s)).filter(s -> s.length() > 12).limit(5).collect(Collectors.toList());
System.out.println("result = " + result);
```

#### 2. stream 대신 parallelStream으로 긴 단어의 개수를 셀 때 차이를 측정하라. 각 호출 이전과 이후에 System.currentTimeMills를 호출하고 차이를 출력한다. 컴퓨터가 빠르다면 전쟁과 평화(War and Peace)처럼 더 큰 문서로 바꿔서 측정한다.

```java
// using commons-lang3
StopWatch stopwatch = new StopWatch();

stopwatch.reset();
stopwatch.start();
long c1 = words.stream().filter(s -> s.length() > 12).count();
stopwatch.stop();
System.out.println("stream = " + stopwatch.toString());

stopwatch.reset();
stopwatch.start();
long c2 = words.parallelStream().filter(s -> s.length() > 12).count();
stopwatch.stop();
System.out.println("parallelStream = " + stopwatch.toString());
```

```
stream = 00:00:00.064
parallelStream = 00:00:00.018
```

#### 3. int&#91;&#93; values = &#123; 1, 4, 9, 16 &#125; 배열이 있다고 하자. Steram.of(values)의 결과는 무엇인가? 이 대신 int의 스트림은 어떻게 얻을 수 있는가?

```java
int[] values = {1, 4, 9, 16};
Stream<int[]> stream = Stream.of(values);
```

```java
int[] values = {1, 4, 9, 16};
IntStream stream = IntStream.of(values);
```

#### 4. Stream.iterate를 사용해 난수의 무한 스트림을 만들어라. 이 때 Math.ranom을 호출하지 말고 선형 적합 발생기를 직접 구현해서 사용해야 한다.

```java
package ch08.ex04;

import java.util.stream.Stream;

public class Random {

	public static Stream<Long> get(long seed, long a, long c, long m) {
		return Stream.iterate(seed, x -> (a * x + c) % m);
	}

}
```

#### 5. 8.3절에서 본 letters 메서드는 먼저 배열 리스트를 채운 후에 스트림으로 변환하므로 약간 어설펏다. 이 메서드 대신 스트림에 기반을 둔 한 줄 짜리 메서드를 작성하라. 0~s.length() - 1 범위의 int 값 스트림을 적절한 람다 표현식으로 매핑히라.

```java
package ch08.ex05;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FilterMap {

	public static Stream<String> letters(String s) {
		return IntStream.rangeClosed(0, s.length() - 1).mapToObj(value -> s.substring(value, value + 1));
	}

}
```

#### 6. String.codePoints 메서드로 문자열이 단어인지, 문자로만 구성되어 있는지 테스트하는 메서드를 구현하라.

```java
package ch08.ex06;

public class StringStream {

	public static boolean isWord(String s) {
		return s.codePoints().allMatch(value -> Character.isAlphabetic(value));
	}

}
```

#### 7. 파일을 토큰 스트림으로 변환한 후 연습문제 6번의 관점에서 단어인 토큰의 처음 100개를 나열하라. 파일을 다시 읽어서 대소문자 구분 없이 가장 자주 나타낸 단어 10개를 나열하라.

```java
words.stream().filter(s -> StringStream.isWord(s)).limit(100)
```

```java
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
```

#### 8. 단어 목록에서 단어를 스트림으로 읽어와서 다섯 가지 별개의 모음을 담은 모든 단어의 배열을 만들어내라.

#### 9. 주어진 유한 문자열의 스트림에서 평균 문자열의 길이를 알아내라.

```java
OptionalDouble average = warandpeace.stream().mapToInt(value -> value.length()).average();
average.ifPresent(value -> System.out.println("average = " + (int) value));
```

#### 10. 주어진 유한 문자열의 스트림에서 길이가 최대인 모든 문자열을 찾아라.

```java
// grouping (length :: list)
Map<Integer, List<String>> grouping = alice.stream().collect(Collectors.groupingBy(String::length));
// get max length
Optional<Map.Entry<Integer, List<String>>> max = grouping.entrySet().stream().collect(Collectors.maxBy(Map.Entry.comparingByKey()));
// print
max.ifPresent(e -> System.out.println(e.getValue()));
```

#### 11. 여려분의 관리자가 public static &lt;T&gt; boolean isFinite(Stream&lt;T&gt; stream) 메서드를 작성하라고 지시했다고 하자. 이 메서드를 작성하는 일이 썩 좋지 못한 생각인 이유는 무엇인가? 어쨋든 지금 바로 작성하자.

|Class|Modifier and Type|Method and Description|
|:--|:--|:--|
|[java.util.Spliterator](https://docs.oracle.com/javase/8/docs/api/java/util/Spliterator.html)|long|[estimateSize](https://docs.oracle.com/javase/8/docs/api/java/util/Spliterator.html#estimateSize--)()<br/>Returns an estimate of the number of elements that would be encountered by a [forEachRemaining(java.util.function.Consumer&lt;? super T&gt;)](https://docs.oracle.com/javase/8/docs/api/java/util/Spliterator.html#forEachRemaining-java.util.function.Consumer-) traversal, or returns Long.MAX_VALUE if infinite, unknown, or too expensive to compute.|

```java
package ch08.ex11;

import java.util.stream.Stream;

public class StreamUtils {

	public static <T> boolean isFinite(Stream<T> stream) {
		return stream.spliterator().estimateSize() != Long.MAX_VALUE;
	}

}
```

#### 12. first와 second 스트림의 요소를 번갈아 넣는 public static &lt;T&gt; Stream&lt;T&gt; zip(Stream&lt;T&gt; first, &lt;T&gt; second) 메서드를 작성하라(현재 차례인 스트림의 요소가 바닥이 나면 null을 넣는다).

#### 13. Stream&lt;ArrayList&lt;T&gt;&gt;에 들어 있는 모든 요소를 ArrayList&lt;T&gt; 한 개로 합쳐라. reduce의 세 가지 형태를 이용해 이 작업을 수행하는 방법을 보여라.

|Modifier and Type|Method and Description|
|:--|:--|
|Optional&lt;T&gt;|[reduce](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html#reduce-java.util.function.BinaryOperator-)(BinaryOperator&lt;T&gt; accumulator)<br/>Performs a reduction on the elements of this stream, using an associative accumulation function, and returns an Optional describing the reduced value, if any.|
|T|[reduce](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html#reduce-T-java.util.function.BinaryOperator-)(T identity, BinaryOperator&lt;T&gt; accumulator)<br/>Performs a reduction on the elements of this stream, using the provided identity value and an associative accumulation function, and returns the reduced value.|
|&lt;U&gt; U|[reduce](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html#reduce-U-java.util.function.BiFunction-java.util.function.BinaryOperator-)(U identity, BiFunction&lt;U,? super T,U> accumulator, BinaryOperator&lt;U&gt; combiner)<br/>Performs a reduction on the elements of this stream, using the provided identity, accumulation and combining functions.|

```java
ArrayList<String> list1 = new ArrayList<>(Arrays.asList("a", "b", "c"));
ArrayList<String> list2 = new ArrayList<>(Arrays.asList("d", "e", "f"));
ArrayList<String> list3 = new ArrayList<>(Arrays.asList("g", "h", "i"));
ArrayList<String> list4 = new ArrayList<>(Arrays.asList("j", "k", "l"));
ArrayList<String> list5 = new ArrayList<>(Arrays.asList("m", "n", "o"));

Stream<ArrayList<String>> stream = Stream.of(list1, list2, list3, list4, list5);
```

```java
/*
 * 잘못된 예
 */
Optional<ArrayList<String>> reduce = stream.reduce((x, y) -> {
    System.out.println("x = " + x + ", y = " + y);
    x.addAll(y);
    return x;
});
// x = [a, b, c], y = [d, e, f]
// x = [a, b, c, d, e, f], y = [g, h, i]
// x = [a, b, c, d, e, f, g, h, i], y = [j, k, l]
// x = [a, b, c, d, e, f, g, h, i, j, k, l], y = [m, n, o]

reduce.ifPresent(v -> System.out.println("result = " + v));
// result = [a, b, c, d, e, f, g, h, i, j, k, l, m, n, o]
System.out.println("list1 = " + list1);
// list1 = [a, b, c, d, e, f, g, h, i, j, k, l, m, n, o]
```

```java
/*
 * reduce(BinaryOperator<T> accumulator)
 */
Optional<ArrayList<String>> reduce = stream.reduce((x, y) -> {
    ArrayList<String> list = new ArrayList<>();
    list.addAll(x);
    list.addAll(y);
    return list;
});

reduce.ifPresent(v -> System.out.println("result = " + v));
// result = [a, b, c, d, e, f, g, h, i, j, k, l, m, n, o]
System.out.println("list1 = " + list1);
// list1 = [a, b, c]
```

```java
/*
 * reduce(T identity, BinaryOperator<T> accumulator)
 */
ArrayList<String> reduce = stream.reduce(new ArrayList<String>(), (x, y) -> {
    x.addAll(y);
    return x;
});
```

```java
/*
 * reduce(U identity, BiFunction<U,? super T,U> accumulator, BinaryOperator<U> combiner)
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
// accumulator = ForkJoinPool.commonPool-worker-2, x = [], y = [a, b, c]
// accumulator = ForkJoinPool.commonPool-worker-2, x = [], y = [m, n, o]
// accumulator = ForkJoinPool.commonPool-worker-1, x = [], y = [d, e, f]
// accumulator = main, x = [], y = [g, h, i]
// combiner = ForkJoinPool.commonPool-worker-1, x = [a, b, c], y = [d, e, f]
// accumulator = ForkJoinPool.commonPool-worker-2, x = [], y = [j, k, l]
// combiner = ForkJoinPool.commonPool-worker-2, x = [j, k, l], y = [m, n, o]
// combiner = ForkJoinPool.commonPool-worker-2, x = [g, h, i], y = [j, k, l, m, n, o]
// combiner = ForkJoinPool.commonPool-worker-2, x = [a, b, c, d, e, f], y = [g, h, i, j, k, l, m, n, o]

System.out.println("result = " + reduce);
// result = [a, b, c, d, e, f, g, h, i, j, k, l, m, n, o]
```

#### 14. Stream&lt;Double&gt;의 평균을 계산하는 데 사용할 수 있는 reduce 호출을 작성하라. 단순히 합계를 계산해 count()로 나눌 수 없는 이유는 무엇인가?

종료 연산을 적용해서 결과를 산출한 후 더 이상 해당 스트림을 사용할 수 없다.

```java
Stream<Double> stream = Stream.generate(() -> Math.random()).limit(20);
Optional<Double> reduce = stream.reduce(Double::sum);
reduce.ifPresent(d -> System.out.println(d / stream.count()));
```

```text
ava.lang.IllegalStateException: stream has already been operated upon or closed

	at java.util.stream.AbstractPipeline.<init>(AbstractPipeline.java:203)
	at java.util.stream.LongPipeline.<init>(LongPipeline.java:91)
	at java.util.stream.LongPipeline$StatelessOp.<init>(LongPipeline.java:572)
	at java.util.stream.ReferencePipeline$5.<init>(ReferencePipeline.java:221)
	at java.util.stream.ReferencePipeline.mapToLong(ReferencePipeline.java:220)
	at java.util.stream.ReferencePipeline.count(ReferencePipeline.java:526)
```

#### 15. BigInteger의 병렬 스트립(paralles stream)과 BigInteger.isProbablePrime 메서드를 이용해서 십진 숫자 50개로 구성된 소수(prime number) 500개를 찾아라. 직렬 스트림(serial stream)을 이용하는 것보다 빠른가?

#### 16. 병렬 스트립을 이용해 전쟁과 평화(War and Peace)에서 가장 긴 문자열 500개를 찾아라. 직렬 스트립을 이용하는 것보다 빠른가?

```java
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
```

```text
stream = 00:00:00.187
parallelStream = 00:00:00.246
```

#### 17. 스트림에서 인접한 중복 요소를 제거할 수 있는가? 병렬 스트림이어도 제시한 방법이 동작할 것 같은가?


