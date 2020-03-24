package com.code.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionTest {


    public static void main(String[] args) {

        String str = "Welcome";
        change(str);
        System.out.println(str);

        Class klass = ReflectedObject.class;
        try {
            ReflectedObject ro = (ReflectedObject) klass.newInstance();

            Method[] methods = klass.getDeclaredMethods();
            for (Method m : methods) {
                if (checkInitMethod(m)) {
                    m.invoke(ro);
                }
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }

    private static boolean checkInitMethod(Method method) {
        return method.getName().startsWith("java")
                && Modifier.isPublic(method.getModifiers())
                && method.getReturnType().equals(Void.TYPE)
                && !method.isVarArgs()
                && !Modifier.isAbstract(method.getModifiers());
    }


    static void change(String str) {
        try {
            Class<?> clazz = str.getClass();
            Field field = clazz.getDeclaredField("value");
            field.setAccessible(true);
            Object obj = field.get(str);
            char[] charValue = (char[]) obj;
            charValue = new char[3];
            for (int i = 0; i < charValue.length; i++) {
                charValue[i] = 'a';
            }
            field.set(str, charValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
