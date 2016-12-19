package concurrency.practise;

/**
 * ≤‚ ‘”√œﬂ≥Ã
 * @author Andre
 *
 */
public class DeadLockAThread implements  Runnable{
	
	private LeftRightDeadLock lr ;
	
	public DeadLockAThread(LeftRightDeadLock lr){
		this.lr = lr;
	}
	
	public void run(){
		getLock();
	}

	private void getLock() {
		lr.leftRight();
	}
	
}
