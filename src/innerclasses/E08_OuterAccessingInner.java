//: innerclasses/E08_OuterAccessingInner.java
/****************** Exercise 8 *****************
 * Determine whether an outer class has access to
 * the private elements of its inner class.
 ***********************************************/
package innerclasses;

import innerclasses.Outer4.Inner;



class Outer4 {
	 class Inner {
		private int j;

		private void h() {
			System.out.println("Inner.h called");
			System.out.println("Inner.j = " + j);
		}
	}

	public void testInnerAccess() {
		Inner i = new Inner();
		i.j = 47;
		i.h();
	}

	private int m;
}

public class E08_OuterAccessingInner {
	public static void main(String args[]) {
		E08_OuterAccessingInner m = new E08_OuterAccessingInner();
		Outer4 o = new Outer4();
		o.testInnerAccess();
		Outer4.Inner in = o.new Inner();
		System.out.println(new Outer4().new Inner());
	}

	public static void go() {
		// when the inner class is static ,it's ok;otherwise ,it's an error
		// Outer4 o = new Outer4();
	}

	public Inner to() {
		return new Outer4().new Inner();
	}

} /*
 * Output: Inner.h called Inner.j = 47
 */// :~
