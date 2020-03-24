//package design_mode.proxy;
//
//import static org.junit.Assert.assertEquals;
//
//import java.lang.reflect.Proxy;
//import org.junit.Before;
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.contrib.java.lang.system.SystemOutRule;
//
//public class DynamicProxyTest {
//
//    private Givegift givegift;
//
//    @Rule
//    public SystemOutRule log = new SystemOutRule().enableLog();
//
//    @Before
//    public void setUp(){
//        Pursuit pursuit = new Pursuit(new SchoolGirl("Mercy"));
//        givegift = (Givegift) Proxy.newProxyInstance(pursuit.getClass().getClassLoader(),
//                pursuit.getClass().getInterfaces(),
//                (proxy, method, args) -> method.invoke(pursuit, args));
//    }
//
//    @Test
//    public void giveFlower() throws Exception {
//        givegift.giveFlower();
//        assertEquals("Mercy,隔壁小王给你送花了\n", log.getLog());
//    }
//
//    @Test
//    public void giveChocolate() throws Exception {
//        givegift.giveChocolate();
//        assertEquals("Mercy,隔壁小王给你送巧克力了\n", log.getLog());
//    }
//
//    @Test
//    public void giveLetter() throws Exception {
//        givegift.giveLetter();
//        assertEquals("Mercy,隔壁小王给你写信了\n", log.getLog());
//    }
//}
