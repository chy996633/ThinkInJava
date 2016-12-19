package chapter9;

public abstract class Instrument {

	private int i;// storage allocated for each

	public abstract void play(Note n);

	public String what() {
		return "Instrument";
	}

	public abstract void adjust();

	class Wind extends Instrument {
		public void play(Note n) {
			System.out.println(("Wind.play()" + n));
		}

		public void adjust() {
		};

		public String what() {
			return "Wind";
		}
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
