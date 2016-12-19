package chapter10.controller;

/*
 *接口Destination,定义一个readLabel()方法
 */
interface Destination {
	String readLabel();
}

/*
 * 接口Contents,定义一个value()方法
 */
interface Contents {
	int value();
}

class Parcel {
	/*
	 * 内部类PContents,实现对接口Contents
	 */
	private class PContents implements Contents {
		private int i = 11;

		public int value() {
			return i;
		}
	}

	/*
	 * 内部类PDestination实现接口Destination
	 */
	protected class PDestination implements Destination {
		private String label;

		private PDestination(String label) {
			this.label = label;
		}

		public String readLabel() {
			return label;
		}
	}

	/*
	 * 方法dest,生成一个PDestination对象,然后向上转型为Destination类型
	 */
	public Destination dest(String s) {
		return new PDestination(s);
	}

	/*
	 * 方法cont,生成一个PContents对象,然后向上转型为Contents类型
	 */
	public Contents cont() {
		return new PContents();
	}
}

/*
 * 类TestParcel,对上面定义的内部进行一个测试
 */
public class Testparcel {
	public static void main(String[] args) {
		Parcel p = new Parcel();
		Contents c = p.cont();
		Destination d = p.dest("Tanzania");
		// 下面的注释掉的语句是错误的
		// Parcel.Contents pc=p.new PContents();
//		Parcel.PDestination = p.new PDestination("sss");
	}
}