package concurrency.practise;

public class DynamicDeadLock {
	//ע�⣺���׷������� T.T
	public void transferMoney(Account from,Account to,int num) throws Exception{
		synchronized(from){
			synchronized(to){
				from.debit(num);
				to.credit(num);
			}
		}
	}
}
