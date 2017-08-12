package com.code;

import net.mindview.util.RandomGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by backstop-samuel on 6/14/17.
 */
public class CopyTest {

    RandomGenerator.String strGen =  new RandomGenerator.String();
    RandomGenerator.Integer intGen = new RandomGenerator.Integer();

    public ArrayList<Student> getStudentArrayList(){
        int i=0;
        ArrayList<Student> collection = new ArrayList<>();
        do {
            Student student = new Student(strGen.next(),intGen.next());
            collection.add((Student) student);
            i++;
        }while (i<10);
        return collection;
    }


    /**
     * new ArrayList这种方式实际上拷贝了一份引用，而不是实际的内存对象。
     */
    public void testNewArrayList(){
        ArrayList<Student> origin =  getStudentArrayList();
        ArrayList<Student> newArray = new ArrayList(origin);
        System.out.println("before set origin, newArrays:"+Arrays.toString(newArray.toArray()));
        Student item = new Student("name",18);
        origin.get(0).setName("name");
        origin.get(0).setAge(18);
        System.out.println("after set origin, newArrays:"+Arrays.toString(newArray.toArray()));

    }

    public void testDeepClone(){
        ArrayList<Student> origin =  getStudentArrayList();
        ArrayList<Student> newArray = new ArrayList<>();
        Iterator<Student> itr = origin.iterator();
        while (itr.hasNext()){
            try {
                newArray.add((Student) itr.next().clone());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("before set origin, newArrays:"+Arrays.toString(newArray.toArray()));
        Student item = new Student("name",18);
        origin.get(0).setName("name");
        origin.get(0).setAge(18);
        System.out.println("after set origin, newArrays:"+Arrays.toString(newArray.toArray()));

    }

    public static void main(String[] args) {
        CopyTest copyTest = new CopyTest();
//        copyTest.testNewArrayList();

        copyTest.testDeepClone();

    }


    class Student implements Cloneable{
        String name;
        Integer age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public Student(String name, Integer age){
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "name:"+name+" age:"+age;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }



}
