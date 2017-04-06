package com.code;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class lambdaTest {

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

//		List<String> languages = Arrays.asList("Java","Sacle","C++","Haskell","Lisp");
//		System.out.println("Language which starts with J");
//		filter(languages,(str)->str.startsWith("J"));


//		 ArrayList arrayList = (ArrayList)Collections.emptyList();




//			List<String> feature = Arrays.asList("Andrew","Frank","Simon");
//			feature.forEach(f -> System.out.println(f));


//		System.out.println(System.getProperty("user.dir"));


		Stream<List<Integer>> inputStream = Stream.of(
				Arrays.asList(1),
				Arrays.asList(2, 3),
				Arrays.asList(4, 5, 6)
		);
		Stream<Integer> outputStream = inputStream.
				flatMap((childList) -> childList.stream());

		System.out.println(outputStream.collect(Collectors.toList()));

		String[] arrays = new String[]{"aaa","bbb","ccc","abc"};
		Arrays.sort(arrays,String::compareToIgnoreCase);
		System.out.println(Arrays.toString(arrays));

		List<String> languages = Arrays.asList("Java","Sacle","C++","Haskell","Lisp");
		languages.stream().map(String::toLowerCase);




	}



}
