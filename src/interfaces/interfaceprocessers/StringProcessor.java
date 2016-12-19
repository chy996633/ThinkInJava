package interfaces.interfaceprocessers;


import java.util.Arrays;

public abstract class StringProcessor implements Processor {
	public static String s = "If she weighs the same as a duck, she's made of wood";

	public String name() {
		return getClass().getSimpleName();
	}

	public static void main(String[] args){
		  Apply.process(new UpperClass() , s);
		  Apply.process(new LowerClass(), s);
		  Apply.process(new Splitter(), s);
	  }
}

class UpperClass extends StringProcessor {
	@Override
	public Object process(Object input) {
		return ((String) input).toUpperCase();
	}
}

class LowerClass extends StringProcessor {
	public Object process(Object input) {
		return ((String) input).toLowerCase();
	}
}

class Splitter extends StringProcessor {
	public String process(Object input) {
		return Arrays.toString(((String) input).split(" "));
	}
}