package com.code;

import java.util.Collection;

/**
 * Created by Andrew on 2016/11/1.
 */
public class GenericTest<T> {

    Collection<T> a;

    public <T> Collection<T> set(Collection<T> a){
        return a;
    }


}
