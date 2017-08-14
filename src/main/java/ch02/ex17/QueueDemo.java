package ch02.ex17;

import ch02.ex17.Queue.Iterator;
import ch02.ex17.Queue.Node;

public class QueueDemo {

	public static void main(String[] args) {
		Queue q = new Queue();
		q.add(new Queue.Node("a"));
		q.add(new Queue.Node("n"));
		q.add(new Queue.Node("t"));
		q.add(new Queue.Node("o"));
		q.add(new Queue.Node("p"));

		Iterator iterator = q.getIterator();
		while (iterator.hasNext()) {
			Node node = iterator.next();

			System.out.println(node);
		}
	}

}
