import ch03.ex06.DigitSequence;
import org.junit.Test;

import java.io.File;
import java.util.*;

public class Chapter03 {

	@Test
	public void ex01() {
		ch03.ex01.Employee e1 = new ch03.ex01.Employee("Jack");
		ch03.ex01.Employee e2 = new ch03.ex01.Employee("Bill");
		ch03.ex01.Employee e3 = new ch03.ex01.Employee("Tom");

		ch03.ex01.Employee[] objects = new ch03.ex01.Employee[]{e1, e2, e3};

		double avg = ch03.ex01.Measurable.average(objects);

		System.out.println("average = " + avg);
	}

	@Test
	public void ex02() {
		ch03.ex02.Employee e1 = new ch03.ex02.Employee("Jack", 5000);
		ch03.ex02.Employee e2 = new ch03.ex02.Employee("Bill", 3000);
		ch03.ex02.Employee e3 = new ch03.ex02.Employee("Tom", 1500);

		ch03.ex02.Employee[] objects = new ch03.ex02.Employee[]{e1, e2, e3};

		ch03.ex02.Measurable measurable = ch03.ex02.Measurable.largest(objects);

		ch03.ex02.Employee e = (ch03.ex02.Employee) measurable;
		System.out.println("employee = " + e.getName());
	}

	@Test
	public void ex04() {
		ch03.ex04.IntSequence seq = ch03.ex04.IntSequence.of(3, 1, 4, 1, 5, 9);

		while (seq.hasNext()) {
			System.out.println("n = " + seq.next());
		}
	}

	@Test
	public void ex05() {
		ch03.ex05.IntSequence seq = ch03.ex05.IntSequence.constant(1);

		int i = 0;
		while (seq.hasNext()) {
			System.out.println("n = " + seq.next());
			i++;
			if (i == 10) {
				break;
			}
		}
	}

	@Test
	public void ex06() {
		DigitSequence seq = new DigitSequence(29382);

		seq.forEachRemaining(integer -> System.out.println(integer));
	}

	@Test
	public void ex07() {
		ArrayList<String> strings = new ArrayList<>();
		strings.add("java");
		strings.add("oracle");
		strings.add("warring");
		strings.add("windows");
		strings.add("eclipse");
		strings.add("node");
		strings.add("lambda");
		strings.add("class");
		strings.add("interface");

		System.out.println(strings);
		ch03.ex07.Sorter.luckySort(strings, (s1, s2) -> s1.compareTo(s2));
		System.out.println(strings);
	}

	@Test
	public void ex08() {
		ch03.ex08.Greeter g1 = new ch03.ex08.Greeter("Bill", 15);
		ch03.ex08.Greeter g2 = new ch03.ex08.Greeter("Jack", 15);

		new Thread(g1).start();
		new Thread(g2).start();
	}

	@Test
	public void ex09() {
		Runnable r1 = () -> {
			for (int i = 0; i < 20; i++) {
				System.out.println("runnable1");

				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {

				}
			}
		};

		Runnable r2 = () -> {
			for (int i = 0; i < 20; i++) {
				System.out.println("runnable2");

				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {

				}
			}

		};

		ch03.ex09.Runner.runTogether(r1, r2);
		// ch03.ex09.Runner.runInOrder(r1, r2);
	}

	@Test
	public void ex10() {
		File directory = new File("C:\\Program Files");
		printDirectories(directory);
	}

	private void printDirectories(File directory) {
		if (!directory.isDirectory()) {
			return;
		}

		File[] directories = directory.listFiles(pathname -> pathname.isDirectory());
		if (directories == null) { // 윈도우의 경우 엑세스 거부는 null이다.
			return;
		}

		for (File d : directories) {
			System.out.println(d);
			printDirectories(d);
		}
	}

	@Test
	public void ex11() {
		String ext = "exe";
		File directory = new File("C:\\Windows");
		printFiles(directory, ext);
	}

	private void printFiles(File directory, String ext) {
		File[] files = directory.listFiles((dir, name) -> name.endsWith("." + ext));

		for (File file : files) {
			System.out.println(file);
		}
	}

	@Test
	public void ex12() {
		// listFiles() 를 하면 이미 제대로 정렬이 다 되서 나오기 때문에 한번 섞어줬다.
		List<File> fileList = Arrays.asList(new File("C:\\Windows").listFiles());
		Collections.shuffle(fileList);
		// input
		File[] files = fileList.toArray(new File[fileList.size()]);

		Arrays.sort(files, (o1, o2) -> {
			if (o1.isDirectory() && o2.isFile()) {
				return -1;
			}
			if (o1.isFile() && o2.isDirectory()) {
				return 1;
			}
			return o1.compareTo(o2);
		});

		for(File file : files) {
			System.out.println(file);
		}
	}

	@Test
	public void ex13() {
		Runnable task1 = () -> {
			for (int i = 0; i < 10; i++) {
				System.out.println("task1");
				try { // delay
					Thread.sleep(500);
				} catch (InterruptedException e) {
				}
			}
		};
		Runnable task2 = () -> {
			for (int i = 0; i < 10; i++) {
				System.out.println("task2");
				try { // delay
					Thread.sleep(500);
				} catch (InterruptedException e) {
				}
			}
		};
		Runnable task3 = () -> {
			for (int i = 0; i < 10; i++) {
				System.out.println("task3");
				try { // delay
					Thread.sleep(500);
				} catch (InterruptedException e) {
				}
			}
		};

		Runnable task = getOrdredRunnable(new Runnable[]{task1, task2, task3});
		task.run();
	}

	private Runnable getOrdredRunnable(Runnable[] tasks) {
		return () -> {
			for (Runnable task : tasks) {
				task.run();
			}
		};
	}

	@Test
	public void ex14() {
		ch03.ex14.Employee[] employees = new ch03.ex14.Employee[]{
				new ch03.ex14.Employee("Qadira", 1500),
				new ch03.ex14.Employee("Jack", 1000),
				new ch03.ex14.Employee("Adolf", 1500),
				new ch03.ex14.Employee("Adolf", 5000),
				new ch03.ex14.Employee("Hades", 3000),
				new ch03.ex14.Employee("Wade", 3700),
				new ch03.ex14.Employee("Kaapo", 2400),
				new ch03.ex14.Employee("Da", 6400)
		};

		Arrays.sort(employees,
				Comparator.comparing(ch03.ex14.Employee::getSalary, (o1, o2) -> (int) (o2 - o1))
						.thenComparing(ch03.ex14.Employee::getName, (o1, o2) -> o1.compareToIgnoreCase(o2))
		);

		for (ch03.ex14.Employee e : employees) {
			System.out.println("salary=" + e.getSalary() + ", name=" + e.getName());
		}
	}

	@Test
	public void ex15() {
		ch03.ex15.IntSequence seq = ch03.ex15.IntSequence.randomInts(10, 100);

		for (int i = 0 ; i < 10; i++) {
			System.out.println(seq.next());
		}
	}


}
