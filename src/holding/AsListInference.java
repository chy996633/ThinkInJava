package holding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


class Snow {}
class Powder extends Snow {}
class Light extends Powder {}
class Heavy extends Powder {}
class Crusty extends Snow {}
class Slush extends Snow {}

public class AsListInference {

	public static void main(String[] args) {
	List<Snow> list = Arrays.asList(new Crusty(), new Slush(), new Powder());
		List<Snow> a =  Arrays.asList(new Light(),new Heavy());

	List<Snow> list2 = Arrays.asList(new Light());
	List<Snow> list3 = new ArrayList<Snow>();
	
	Collections.addAll(list3,new Light(),new Heavy());
	
	List<Snow> list4 = Arrays.<Snow>asList(new  Light(),new Heavy());
	
	}
	
}
