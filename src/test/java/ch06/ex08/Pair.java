package ch06.ex08;

public class Pair<E extends Comparable> {

	private E left;
	private E right;

	public Pair(E left, E right) {
		this.left = left;
		this.right = right;
	}

	public E getLeft() {
		return left;
	}

	public E getRight() {
		return right;
	}

	public E getMin() {
		return left.compareTo(right) <= 0 ? left : right;
	}

	public E getMax() {
		return left.compareTo(right) <= 0 ? right : left;
	}

}