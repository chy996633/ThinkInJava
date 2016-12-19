package beanUtils;

import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.LazyDynaBean;

/**
 * Created by Andrew on 2015/12/6.
 */
public class LazyDynaBeanTest {

    public static void main(String[] args) {
        DynaBean lazyBean = new LazyDynaBean();
        lazyBean.set("foo","bar");
        lazyBean.set("number",2);
        lazyBean.set("truth",false);
        lazyBean.set("object",new Object());

        lazyBean.set("map","20112601604","Andrew");
        lazyBean.set("map","20112601605","Frank");

        lazyBean.set("index",0,3);
        lazyBean.set("index", 1, "str");

        System.out.println(lazyBean.get("index"));
        lazyBean.set("mamama",true);
        System.out.println(lazyBean.get("mamama"));

    }
}
