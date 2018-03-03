package ch02.ex16;

import java.util.ArrayList;

public class Queue {

	/**
	 * 문자열을 담고 있는 노드
	 * 
	 * @author antop
	 *
	 */
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

	// 노드를 가지고 있는 배열 리스트
	private final ArrayList<Node> list = new ArrayList<>();

	/**
	 * 마지막에 노드 추가
	 * 
	 * @param node
	 *            추가할 노드
	 */
	public void add(Node node) {
		list.add(node);
	}

	/**
	 * 맨 처음 노드 제거
	 * 
	 * @return 제거된 노드
	 */
	public Node remove() {
		return list.remove(0);
	}

}
