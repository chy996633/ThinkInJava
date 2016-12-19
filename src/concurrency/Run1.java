package concurrency;

public class Run1 implements Runnable {

	private int i = 0;

	@Override
	public void run() {

		for (int j = 0; j < 100; j++) {
			i++;
			if (i % 1000 == 0) {
				System.out.println(i);
			}
		}
	}

}
