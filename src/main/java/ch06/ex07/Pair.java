package ch06.ex07;

public class Pair<E> {

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

}
