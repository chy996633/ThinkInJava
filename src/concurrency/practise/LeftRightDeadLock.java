package concurrency.practise;

public class LeftRightDeadLock {
	// 注意：容易发生死锁
	private final Object left = new Object();
	private final Object right = new Object();
	int num;

	public void leftRight() {
		synchronized (left) {
			synchronized (right) {
				num++;
				doSomething(num);
			}
		}
	}

	public void rightLeft() {
		synchronized (right) {
			synchronized (left) {
				num++;
				doSomethingElse(num);
			}
		}
	}

	private void doSomethingElse(int num) {
		if (num % 100 == 0) {
			System.out.println(num);
		}
	}

	private void doSomething(int num) {
		if (num % 100 == 0) {
			System.out.println(num);
		}
	}

}
