package com.code;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class lambdaTest {

	public void test() throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {

		Class<?> cla = Class.forName("com.code.Sequence");
		Method me = cla.getMethod("SequenceSelector");

		me.invoke(cla.newInstance());
	}

	public static void filter(List<String> names,Predicate condition){
		names.stream().filter(
				(name)->(condition.test(name))
		)
		.forEach((name) -> System.out.println(name + " "));
	}
	
	public static void main(String[] args) {
//			new Test().test();

//		new Thread(()-> System.out.println("New Java 8 way") ).start();

//		JButton show = new JButton("show");
//		show.addActionListener((e) ->{
//			System.out.println("Light.Camera,Action!!");
//		});

//		List<String> languages = Arrays.<String>asList("Java","Sacle","C++","Haskell","Lisp");
//		System.out.println("Language which starts with J");
//		filter(languages,(str)->str.startsWith("J"));


//		 ArrayList arrayList = (ArrayList)Collections.emptyList();




//			List<String> feature = Arrays.asList("Andrew","Frank","Simon");
//			feature.forEach(f -> System.out.println(f));


//		System.out.println(System.getProperty("user.dir"));




	}
}
