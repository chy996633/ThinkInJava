package concurrency.practise;

/**
 * 银行账户线程模拟
 * @author Andre
 *
 */
public class DynamicDeadLockThread implements Runnable{

	private DynamicDeadLock ddl;
	private Account to;
	private Account from;
	
	public DynamicDeadLockThread(DynamicDeadLock ddl,Account from,Account to){
		this.ddl = ddl;
		this.to = to;
		this.from = from;
	}
	
	public void run() {
		try {
			ddl.transferMoney(from, to, 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
