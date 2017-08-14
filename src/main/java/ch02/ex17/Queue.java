package ch02.ex17;

import java.util.ArrayList;

public class Queue {

	public static class Node {
		private final String value;

		public Node(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		@Override
		public String toString() {
			return "Node [value=" + value + "]";
		}

	}

	private final ArrayList<Node> list = new ArrayList<>();

	public void add(Node node) {
		list.add(node);
	}

	public Node remove() {
		return list.remove(0);
	}

	/**
	 * 이터레이터를 반환한다. {@link Queue}의
	 * 
	 * @author antop
	 *
	 */
	public class Iterator {

		private int index = 0;

		public boolean hasNext() {
			return index < list.size();
		}

		public Node next() {
			return list.get(index++);
		}
	}

	/**
	 * 이터레이터를 반환한다.
	 * 
	 * @return
	 */
	public Iterator getIterator() {
		return new Iterator();
	}

}
