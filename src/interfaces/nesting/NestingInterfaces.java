//: interfaces/nesting/NestingInterfaces.java
package interfaces.nesting;

class A {
	public interface B {
		void f();
	}

	private class AImp implements B {
		public void f() {
		};
	}

	public class AImp2 implements B {
		public void f() {
		};
	}

	interface C {
		void f();
	}

	class CImp implements C {
		public void f() {
		};
	}

	public class CImp2 implements C {
		public void f() {
		};
	}

	private interface D {
		void f();
	}

	private class DImp implements D {
		public void f() {
		};
	}

	public class DImp2 implements D {
		public void f() {
		};
	}
	
	public D getD(){
		return new DImp2();
	}
	
	private D d;
	public void receiveD(D dimp){
		this.d = dimp;
		d.f();
	}

}

interface E {
	interface G {
		void f();
	}

	// Redundant "public":
	public interface H {
		void f();
	}

	void g();
	// Cannot be private within an interface:
	// ! private interface I {}
}

public class NestingInterfaces {
	public class BImp implements A.B {
		public void f() {
		}
	}

	class CImp implements A.C {
		public void f() {
		}
	}

	// Cannot implement a private interface except
	// within that interface's defining class:
	// ! class DImp implements A.D {
	// ! public void f() {}
	// ! }
	class EImp implements E {
		public void g() {
		}
	}

	class EGImp implements E.G {
		public void f() {
		}
	}

	class EImp2 implements E {
		public void g() {
		}

		class EG implements E.G {
			public void f() {
			}
		}
	}

	public static void main(String[] args) {
		A a = new A();
		// Can't access A.D:
		// ! A.D ad = a.getD();
		// Doesn't return anything but A.D:
		// ! A.DImp2 di2 = a.getD();
		// Cannot access a member of the interface:
		// a.getD().f();
		a.getD();
		// Only another A can do anything with getD():
		A a2 = new A();
		a2.receiveD(a.getD());
	}
} // /:~
