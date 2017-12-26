package generics;

import static org.junit.Assert.assertEquals;
import java.math.BigDecimal;
import org.junit.Test;

public class TupleTest {

    @Test
    public void testTwoTuple() throws Exception {
//        TwoTuple tuple = new TwoTuple("first", "2");
        TwoTuple tuple = Tuple.tuple("first", "2");
        assertEquals("( first , 2 )", tuple.toString());
    }

    @Test
    public void testThreeTuple() {
//        ThreeTuple threeTuple = new ThreeTuple("A", 2, new BigDecimal("2.333"));
        ThreeTuple threeTuple = Tuple.tuple("A", 2, new BigDecimal("2.333"));
        assertEquals("( A , 2 , 2.333 )", threeTuple.toString());
    }

    @Test
    public void testFourTuple() {
        FourTuple fourTuple = Tuple.tuple("A", 2, new BigDecimal("2.333"), true);
        assertEquals("( A , 2 , 2.333 , true )", fourTuple.toString());
    }

    //fiveTuple

}