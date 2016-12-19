package concurrency.practise;

public class DynamicDeadlockTest {
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
		DynamicDeadLock dd  = new DynamicDeadLock();
		Account a = new Account("a");
		Account b = new Account("b");
		DynamicDeadLockThread c = new DynamicDeadLockThread(dd,a,b);
		DynamicDeadLockThread d = new DynamicDeadLockThread(dd,b,a);
		
		
		
		test.runInGroup(c, d, 2000);

	}

	

}
