import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyTest {

    public static void main(String[] args) {

        //第二步：创建被代理对象，生成调用处理器
        DynamicProxy ih = new DynamicProxy(new Person() {
            @Override
            public void say() {
                System.out.println("Im andrew");
            }

            @Override
            public void sing() {
                System.out.println("Im singing");
            }
        });

        //第三步：创建Proxy.newInstance
        Person andrew = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class[] {Person.class}, ih);
        andrew.say();
        andrew.sing();
        // 正常打印代理类方法

    }


}

interface Person {
    void say();
    void sing();
}


//使用动态代理第一步：定义调用处理器
class DynamicProxy implements InvocationHandler {
    Person person;

    public DynamicProxy(Person person) {
        this.person = person;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Im proxy, this is me");
        Object returnValue = method.invoke(person, args);
        return returnValue;
    }
}