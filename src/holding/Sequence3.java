package holding;

import java.util.ArrayList;

interface Selector {
	boolean end();

	Object current();

	void next();
}

public class Sequence3 {
	private ArrayList<Object> items = new ArrayList<Object>();

	public void add(Object o) {
		items.add(o);
	}

	private class Sequence3Selector implements Selector {
		private int i = 0;

		public boolean end() {
			return i == items.size();
		}

		public Object current() {
			return items.get(i);
		}

		public void next() {
			i++;
		}
	}

	public Selector getSelector() {
		return new Sequence3Selector();
	}

	public static void main(String[] args) {
		Sequence3 s = new Sequence3();
		for(int i=0;i<10;i++){
			s.add(i);
		}
		Selector selector =  s.getSelector();
		while(!selector.end()){
			System.out.println(selector.current() + "  ");
			selector.next();
		}
		s.add(10);
		s.add(11);
		s.add(12);
		s.add(13);
		s.add(13);
		s.add("good bye");
		while(!selector.end()){
			System.out.println(selector.current()+" ");
			selector.next();
		}
		
		
	}

}
