package com.code;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.swing.JOptionPane;

public class ClassForName {

	/**
	 * 构造方法
	 */
	public ClassForName() {

		String classInfo = JOptionPane.showInputDialog(null, "输入类全路径");// 要求用户输入全路径

		try {

			Class<?> cla = Class.forName(classInfo);

			Method[] methods = cla.getDeclaredMethods();// 利用得到的CLass对象的自审，返回该类的Class对象

			System.out.println("forName:" + cla);

			for (Method m : methods) {
				System.out.println("方法有：" + m.toString());// 打印方法信息
			}

			System.out.println("*******************");

			Field[] fields = cla.getDeclaredFields();

			for (Field f : fields) {
				System.out.println("属性有：" + f.toString());// 打印属性信息
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		while (true) {
			new ClassForName();
		}

	}

}
