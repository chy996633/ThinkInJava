package concurrency.practise;

public class DynamicDeadLock {
	//注意：容易发生死锁 T.T
	public void transferMoney(Account from,Account to,int num) throws Exception{
		synchronized(from){
			synchronized(to){
				from.debit(num);
				to.credit(num);
			}
		}
	}
}
