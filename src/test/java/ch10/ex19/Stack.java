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
