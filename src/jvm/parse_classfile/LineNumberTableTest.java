package jvm.parse_classfile;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LineNumberTableTest {

    FileInputStream fileInputStream;

    @Before
    public void setUp() throws Exception {
        fileInputStream = new FileInputStream("src/jvm/parse_classfile/LineNumberTest.txt");

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testRead(){
        LineNumberTable lineNumberTable = new LineNumberTable();
        lineNumberTable.read(fileInputStream);

        assertEquals(10, lineNumberTable.attrNameIndex);
        assertEquals(6, lineNumberTable.attrLength);
        assertEquals(1, lineNumberTable.getLineNumberTableLength());
        assertEquals(0, lineNumberTable.getLineNumberInfoList().get(0).getStartPC());
        assertEquals(3, lineNumberTable.getLineNumberInfoList().get(0).getLineNumber());
    }
}