#### 1. 병렬 스트림으로 디렉터리에서 주어진 단어가 포함된 파일을 모두 찾아라. 그중 첫 번째 파일만 찾으려면 어떻게 해야 하는 가 파일이 실제로 동시에 검색되는가?

#### 2. 여러분의 컴퓨터에서 Arrays.parallelSort가 Arrays.sort보다 빠르려면 배열이 얼마나 커야 하는가?

#### 3. 파일 안에서 주어진 단어를 찾으려고 시도하면서, 모든 단어를 읽는 태스크를 돌려주는 메서드를 구현하라. 이 태스크는 인터럽트되면 즉시 디버그 메시지를 출력해야 하며 종료해야 한다. 디렉터리에 들어 있는 모든 파일 각각에 태스크를 하나씩 스케줄링하라. 그중 하나가 성공하면 나머지 태스크를 모두 인터럽트해야 한다.

#### 4. 병렬 연산 parallelPrefix 메서드는 본문에서 설명하지 않았다. 이 메서드는 각 배열 요소를 주어진 결합 연산에 대한 프리픽스의 누적으로 교체한다. 대체 무슨 말일까?

#### 5. 여러 스레드로 파일 컬렉션에 있는 단어를 모두 읽는 애플리케이션을 작성하라. ConcurrentHashMap&lt;String, Set&lt;File&gt;&gt;로 각 단어가 나타난 파일을 추적한다. 맵을 업데이트하는 데는 merge 메서드를 이요한다.

#### 6. 연습문제 5번을 반복하되, 이번에는 computeIfAbsent를 이용하라. 이 접근 방식의 장점은 무엇인가?

#### 7. ConcurrentHashMap&lt;String, Long&gt;에서 최댓값과 연관된 키를 찾아라(값이 같으면임의로 선택한다). (힌트: reduceEntires를 이용한다)

#### 8. 각각 카운터를 100,000번 증가시키는 스레드 1,000개를 생성하라. AtomicLong을 이용할 때와 LongAdder를 이용할 때의 퍼포먼스를 비교하라.

#### 9. LongAccumulator로 누적 요소의 최댓값 또는 최솟값을 계산하라.

#### 10. 블로킹 큐로 디렉터리에 있는 파일을 처리하라. 한 스레드는 파일 트리를 순회하여 큐에 파일을 삽입한다. 다른 여러 스레드는 파일을 제거하고 주어진 키워드에 해당하는 각 파일을 검색하여, 일치하는 파일을 출력한다. 생산자는 작업을 마칠 때 큐에 더미 파일을 집어넣어야 한다.

#### 11. 연습문제 10번을 반복하되, 이번에는 각 소비자가 단어들의 맵과 두 번째 큐에 삽입된 단어의 빈도수를 편집하게 하라. 마지막 스레드는 사전들을 병합하고 가장 자주 나타난 단어 10개를 출력해야 한다. ConcurrentHashMap을 이용할 필요가 없는 이유는 무엇인가?

#### 12. 연습문제 11번을 반북하되, 이번에는 각 파일별로 Callable&lt;Map&lt;String, Integer&gt;&gt;를 만들고 적절한 실행자 서비스를 이용하라. 모든 결과가 나오면 결과들을 병합해야 한다. ConcurrentHashMap을 이용할 필요가 없는 이유는 무엇인가?

#### 13. 연습문제 12번을 반복하되, 이번에는 결과들을 병합하는 데 ExecutorCompletionService를 이용하고 결과들이 나오는 즉시 병합하라.

#### 14. 연습문제 13번을 반복하되, 이번에는 단어의 빈도수를 모으는 데 전역 ConcurrentHashMap을 이용하라.

#### 15. 연습문제 14번을 반복하되, 이번에는 병렬 스트림을 이용하라. 어떤 스트림 연산도 부가 작용이 없어야 한다.

#### 16. 디렉터리 트리를 순회하면서 각 파일을 처리할 스레드를 만드는 프로그램을 작성하라. 각 스레드에서는 해당 파일에 있는 단어의 개수를 세고, 잠금을 이용하지 않으며 다음과 같이 선언된 공유 카운터를 업데이트한다.

```java

```

프로그램을 여러 번 실행해보자. 무슨 일이 일어나느가? 그리고 그 이유는 무엇인가?

#### 17. 잠금으로 연습문제 16번에서 만든 프로그램을 고쳐라.

#### 18. LongAdder로 연습문제 16번에서 만든 프로그램을 고쳐라.

#### 19. 다음 스택 구현이 있다고 하자.

```java
package ch10.ex19;

public class Stack {

	class Node {
		Object value;
		Node next;
	}

	private Node top;

	public void push(Object newValue) {
		Node n = new Node();
		n.value = newValue;
		n.next = top;
		top = n;
	}

	public Object pop() {
		if (top == null) return null;
		Node n = top;
		top = n.next;
		return n.value;
	}

}
```

이 자료 구조에 올바른 요소가 포함되지 않게 하는 방법 두 가지를 설명하라.

#### 20. 다음 큐 구현이 있다고 하자.

```java
package ch10.ex20;

public class Queue {

	class Node {
		Object value;
		Node next;
	}

	private Node head;
	private Node tail;

	public void add(Object newValue) {
		Node n = new Node();
		if (head == null) {
			head = n;
		} else {
			tail.next = n;
		}
		tail = n;
		tail.value = newValue;
	}

	public Object remove() {
		if (head == null) return null;
		Node n = head;
		head = n.next;
		return n.value;
	}

}
```

이 자료 구조에 올바른 요소가 포함되지 않게 하는 방법 두 가지를 설명하라.

#### 21. 다음 코드 조각은 무엇이 잘못되었는가?

```java
package ch10.ex21;

public class Stack {
	private Object myLock = "LOCK";

	public void push(Object newValue) {
		synchronized (myLock) {
			// ...
		}
	}

	// ...
}
```

#### 22. 다음 코드 조각은 무엇이 잘못되었는가?

```java
package ch10.ex22;

import java.util.concurrent.locks.ReentrantLock;

public class Stack {
	public void push(Object newValue) {
		synchronized (new ReentrantLock()) {
			// ...
		}
	}

	// ...
}
```


#### 23. 다음 코드 조각은 무엇이 잘못되었는가?

```java
package ch10.ex23;

import java.util.Arrays;

public class Stack {

	private Object[] values = new Object[10];
	private int size;

	public void push(Object newValue) {
		synchronized (values) {
			if (size == values.length) {
				values = Arrays.copyOf(values, 2 * size);
			}
			values[size] = newValue;
			size++;
		}
	}

}
```

#### 24. 사용자에게 URL을 입력하도록 요청하고, 해당 URL에 있는 웹 페이지를 읽어서 모든 링크를 표시하는 프로그램을 작성하라. 각 단계에서 CompletableFuture를 사용한다. 그리고 get은 호출하지 않아야 한다. 프로그램이 이른 시점에 종료되지 않게 다음 메서드를 호출해야 한다.

```java
ForkJoinPool.commonPool().awaitQuiescence(10, TimeUnit.SECONDS);
```

#### 25. 비동기로 샐행해야 하는 until 함수에서 받아들이는 값을 생산할 때까지 액션을 비동기로 반복하는 다음 메서드를 작성하라

```java
public static <T> CompletableFuture<T> repeat(Supplier<T> action, Predicate<T> until)
```

콘솔에서 java.net.PasswordAuthentication을 읽는 함수와 1초간 잠든 후 패스워드가 "secret"인지 검사하는 유효성 검사를 시뮬레이션하는 함수로 테스트해보자. (힌트: 재귀를 이용한다)