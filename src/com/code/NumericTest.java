package com.code;

/**
 * Created by backstop-samuel on 7/2/17.
 *
 * Java Spec
 A compound assignment expression of the form E1 op= E2 is equivalent to E1 = (T) ((E1) op (E2)), where T is the type of E1, except that E1 is evaluated only once.

 For example, the following code is correct:

 short x = 3;
 x += 4.6;
 and results in x having the value 7 because it is equivalent to:

 short x = 3;
 x = (short)(x + 4.6);

 */
public class NumericTest {

    public static void main(String[] args) {
        int i = 2;
        i += (double)0.88;
        System.out.println(i);

    }

}
