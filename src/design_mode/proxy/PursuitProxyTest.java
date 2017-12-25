package design_mode.proxy;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

public class PursuitProxyTest {

    private PursuitProxy proxy;

    @Rule
    public SystemOutRule log = new SystemOutRule().enableLog();

    @Before
    public void setUp(){
        proxy = new PursuitProxy(new SchoolGirl("Mercy"));
    }

    @Test
    public void giveFlower() throws Exception {
        proxy.giveFlower();
        assertEquals("Mercy,隔壁小王给你送花了\n", log.getLog());
    }

    @Test
    public void giveChocolate() throws Exception {
        proxy.giveChocolate();
        assertEquals("Mercy,隔壁小王给你送巧克力了\n", log.getLog());
    }

    @Test
    public void giveLetter() throws Exception {
        proxy.giveLetter();
        assertEquals("Mercy,隔壁小王给你写信了\n", log.getLog());
    }

}