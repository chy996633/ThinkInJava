package chapter15;

import java.util.*;

/**
 * Created by Andrew on 2015/9/28.
 */
public class LimitsOfInference {
    static void f(Map<Object,List<? extends Object>> person) {}

    public static void main(String[] args) {
//        f(New.map()); �����ж�ֻ�Ը�ֵ������Ч����Ϊ�������õĲ���ʱ��Ч����������Ϊ�����÷��ͷ���֮���䷵����������һ��Object���͵ı���
        f(New.<Object,List<? extends Object>>map());//��ʾ������˵�����������﷨������
    }
}
