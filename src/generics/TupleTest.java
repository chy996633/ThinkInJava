package generics;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import org.junit.Assert;
import org.junit.Test;

public class TupleTest {

    @Test
    public void testTwoTuple() throws Exception {
        TwoTuple tuple = new TwoTuple("first", "2");
        assertEquals("( first , 2 )",tuple.toString());
    }

    @Test
    public void testThreeTuple(){
        ThreeTuple threeTuple = new ThreeTuple("A",2,new BigDecimal("2.333"));
        assertEquals("( A , 2 , 2.333 )", threeTuple.toString());
    }

    @Test
    public void testFourTuple(){
        FourTuple fourTuple = new FourTuple("A",2,new BigDecimal("2.333"),true);
        assertEquals("( A , 2 , 2.333 , true )",fourTuple.toString());
    }

    //fiveTuple

}