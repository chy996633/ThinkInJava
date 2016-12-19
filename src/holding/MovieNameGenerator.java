package holding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class MovieNameGenerator {

	String[] character = { "Grumpy", "Happy", "Sleepy", "Dopey", "Doc",
			"Sneezy", "Bashful", "Snow White", "Witch Queen", "Prince" };
	private int next = 0;

	public String next() {
		String s = character[next];
		next = (next + 1) % character.length;
		return s;
	}

	private static final MovieNameGenerator mg = new MovieNameGenerator();

	// 用多态定义fill函数
	static String[] fill(String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = mg.next();
		}
		return arr;
	}

	static Collection<String> fill(Collection<String> c) {
		for (int i = 0; i < 5; i++) {
			c.add(mg.next());
		}
		return c;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.asList(fill(new String[5])));
		System.out.println(fill(new ArrayList<String>()));
		System.out.println(fill(new LinkedList<String>()));
		System.out.println(fill(new HashSet<String>()));
		System.out.println(fill(new TreeSet<String>()));
		System.out.println(fill(new LinkedHashSet<String>()));

	}

}
