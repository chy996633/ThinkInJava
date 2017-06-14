package com.code;

import net.mindview.util.RandomGenerator;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by backstop-samuel on 6/14/17.
 */
public class CopyTest {

    RandomGenerator.String gen =  new RandomGenerator.String();

    public ArrayList<String> getStringArrayList(){
        int i=0;
        ArrayList<String> collection = new ArrayList<>();
        do {
            collection.add(gen.next());
            i++;
        }while (i<10);
        return collection;
    }


    /**
     * new ArrayList这种方式实际上拷贝了一份引用，而不是实际的内存对象。
     */
    public void testNewArrayList(){
        ArrayList<String> origin =  getStringArrayList();
        ArrayList<String> newArray = new ArrayList(origin);
        origin.set(0,"aaaaa");
        Assert.assertFalse(newArray.contains("aaaaa"));
    }

    public static void main(String[] args) {
        CopyTest copyTest = new CopyTest();
        copyTest.testNewArrayList();

    }




}
