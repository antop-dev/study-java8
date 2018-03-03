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
