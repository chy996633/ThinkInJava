package chapter10.controller;

class WithInner {
	class Inner {
		Inner(int i) {

		}
	}
}

public class InheritInner extends WithInner.Inner {
	InheritInner(WithInner wi ,int i) {
		wi.super(i);
	}

}
