package com.code;

import java.util.Collection;

/**
 * Created by Andrew on 2016/11/1.
 */
public class SubGenericClass<T> extends GenericTest {

    @Override
    public Collection set(Collection a) {
        return super.set(a);
    }

//    Collection<T> set(Collection<T> b){
//        return b;
//    }


}
