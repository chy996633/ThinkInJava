package beanUtils;

import org.apache.commons.beanutils.*;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

/**
 * Created by Andrew on 2015/12/6.
 */
public class DynaBeanTest {


    public static void main(String[] args) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        DynaProperty[] properties = new DynaProperty[]{
                new DynaProperty("address",java.util.Map.class),
                new DynaProperty("subordinate",beanUtils.Employee[].class),
                new DynaProperty("firstName",String.class),
                new DynaProperty("lastName",String.class)
        };

        BasicDynaClass dynaBeanClass = new BasicDynaClass("employee",null,properties);

        DynaBean employee =   dynaBeanClass.newInstance();
        employee.set("address",new HashMap<>());
        employee.set("subordinate",new Employee[0]);
        employee.set("firstName",new String("Andrew"));
        employee.set("lastName", new String("chen"));
//        employee.set("kasd",new String());

        System.out.println(PropertyUtils.getProperty(employee, "firstName"));
        System.out.println(PropertyUtils.getProperty(employee, "lastName"));

    }


}
