package beanUtils;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Andrew on 2015/12/4.
 */
public class BeanUtilsTest {

    public static void main(String[] args) {
        Employee employee = new Employee();
        try {

            System.out.println((String) PropertyUtils.getSimpleProperty(employee, "firstName"));
            System.out.println((String)PropertyUtils.getSimpleProperty(employee, "lastName"));
            System.out.println(PropertyUtils.getIndexedProperty(employee, "subordinate[0]"));
            System.out.println(PropertyUtils.getMappedProperty(employee, "address(home)"));
            System.out.println(PropertyUtils.getNestedProperty(employee, "address(home).city"));




        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
}
