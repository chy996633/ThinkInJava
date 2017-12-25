package generics;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class TwoTupleTest {

    @Test
    public void toStringTest() throws Exception {
        TwoTuple tuple = new TwoTuple("first", "2");
        assertEquals("( first, 2 )",tuple.toString());
    }

}