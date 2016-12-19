package chapter15;

/**
 * Created by Andrew on 2015/10/6.
 */

/**
 * 一个类不能实现同一个泛型接口的两种变体
 * @param <T>
 */
public interface Payable<T> {
}

class Employee implements Payable<Coffee>{}

//class Hourly extends Employee implements Payable<Object>{}

