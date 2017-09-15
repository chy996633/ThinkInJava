package beanUtils;

import com.sun.xml.internal.ws.util.StringUtils;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Map.Entry;

public class MyBeanUtils {

    static Class klass;

    public static void populate(Object bean, Map<String, String> map){
        klass = bean.getClass();
        for (Entry<String, String> entry: map.entrySet()){
            String attributeName = entry.getKey();
            String value = entry.getValue();

            try {
                Field field = klass.getDeclaredField(attributeName);
                setProperty(bean, field, value);
            } catch (NoSuchFieldException e) {
                System.out.println("no attribute:"+ attributeName);
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

        }


    }

    private static void setProperty(Object bean, Field field, String value)
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class fieldClass = field.getType();
        if (fieldClass == Integer.class){
            Method method = klass.getDeclaredMethod("set"+ StringUtils.capitalize(field.getName()), Integer.class);
            method.invoke(bean, Integer.valueOf(value));
        }else if (fieldClass == boolean.class){
            Method method = klass.getDeclaredMethod("set"+ StringUtils.capitalize(field.getName()), Boolean.class);
            method.invoke(bean, Boolean.valueOf(value));
        }else if (fieldClass == String.class){
            Method method = klass.getDeclaredMethod("set"+ StringUtils.capitalize(field.getName()), String.class);
            method.invoke(bean, value);
        }else {
            System.out.println("field type not supported yet.");
        }

    }

}
