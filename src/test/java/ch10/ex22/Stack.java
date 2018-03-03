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
