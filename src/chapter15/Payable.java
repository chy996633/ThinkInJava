package chapter15;

/**
 * Created by Andrew on 2015/10/6.
 */

/**
 * һ���಻��ʵ��ͬһ�����ͽӿڵ����ֱ���
 * @param <T>
 */
public interface Payable<T> {
}

class Employee implements Payable<Coffee>{}

//class Hourly extends Employee implements Payable<Object>{}

