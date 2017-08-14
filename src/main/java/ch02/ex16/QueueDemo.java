package ch02.ex16;

import ch02.ex16.Queue.Node;

public class QueueDemo {

	public static void main(String[] args) {
		Queue q = new Queue();
		q.add(new Queue.Node("a"));
		q.add(new Queue.Node("n"));
		q.add(new Queue.Node("t"));
		q.add(new Queue.Node("o"));
		q.add(new Queue.Node("p"));

		Node node = q.remove();

		System.out.println("removed node. " + node);
	}

}
