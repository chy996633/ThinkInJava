package concurrency.practise;
/**
 * B�߳�
 * @author Andre
 *
 */
public class DeadLockBThread implements  Runnable{

	private LeftRightDeadLock lr ;
	
	public DeadLockBThread(LeftRightDeadLock lr){
		this.lr = lr;
	}
	
	public void run(){
		getLock();
	}

	private void getLock() {
		lr.rightLeft();
	}
	
}
