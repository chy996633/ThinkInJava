package chapter15;

import java.util.*;

/**
 * Created by Andrew on 2015/9/28.
 */
public class LimitsOfInference {
    static void f(Map<Object,List<? extends Object>> person) {}

    public static void main(String[] args) {
//        f(New.map()); 类型判断只对赋值操作有效，作为方法调用的参数时无效，编译器认为：调用泛型方法之后，其返回至被赋予一个Object类型的变量
        f(New.<Object,List<? extends Object>>map());//显示的类型说明，但这种语法很少用
    }
}
