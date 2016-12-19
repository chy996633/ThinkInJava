package concurrency.practise;

public class Account {
	String name;
	int money=10000;

	public Object getBalance() {
		return null;
	}
	
	public Account(String name){
		this.name = name;
	}

	public void debit(int num) {
		money -=num;
		doSomethingElse(money);
	}

	public void credit(int num) {
		money+=num;
		doSomething(money);
		
	}

	private void doSomethingElse(int num) {
//		if (num % 100 == 0) {
			System.out.println(name+"转出后还剩:"+num);
//		}
	}
	
	private void doSomething(int num) {
//		if (num % 100 == 0) {
			System.out.println(name+"进账后有:"+num);
//		}
	}
	
	
}
