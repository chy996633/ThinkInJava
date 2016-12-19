package concurrency.practise;

public class LeftRightDeadLockTest {

	/**
	 * 让线程并发执行
	 */
	public void runInGroup(Runnable a, Runnable b, int n) {
		for (int i = 0; i < n; i++) {
			Thread ta = new Thread(a);
			Thread tb = new Thread(b);
			ta.start();
			tb.start();
		}
	}

	public static void main(String[] args) {
		LeftRightDeadLockTest test = new LeftRightDeadLockTest();
		LeftRightDeadLock lr = new LeftRightDeadLock();
		DeadLockAThread a = new DeadLockAThread(lr);
		DeadLockBThread b = new DeadLockBThread(lr);

		test.runInGroup(a, b,20000);

	}

}
