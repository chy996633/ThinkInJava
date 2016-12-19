package holding;

import java.util.Iterator;

public class IterableString implements Iterable<Character> {
	String original = null;
	public IterableString(String original){
		this.original = original;
	}
	
	@Override
	public Iterator<Character> iterator() {
		return new InnerIterator();
	}
	
	private class InnerIterator implements Iterator<Character>{
		private int index = 0;
		
		@Override
		public boolean hasNext() {
			return index<original.length()?true:false;
		}

		@Override
		public Character next() {
			return original.charAt(index++);
		}
		@Override
		public void remove() {
		}
	}
	
	public static void main(String[] args){
		for(Character a: new IterableString("Andrew")){
			System.out.println(a);
		}
//		Iterator<Character> itr = new IterableString("Andrew").iterator();
//		while(itr.hasNext()){
//			System.out.println(itr.next());
//		}
	}
}

