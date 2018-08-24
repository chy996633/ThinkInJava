package jvm.parse_classfile;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import jvm.parse_classfile.CodeAttribute.LineNumberTable;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CodeAttributeTest {

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
        int attrNameOfCodeIndex = U2.read(fileInputStream);
        int attrOfCodeLength = U4.read(fileInputStream);
        LineNumberTable codeAttribute = new CodeAttribute(attrNameOfCodeIndex, attrOfCodeLength).new LineNumberTable(attrNameOfCodeIndex, attrOfCodeLength);
        codeAttribute.read(fileInputStream);

        assertEquals(10, codeAttribute.attrNameIndex);
        assertEquals(6, codeAttribute.attrLength);
        assertEquals(1, codeAttribute.getLineNumberTableLength());
        assertEquals(0, codeAttribute.getLineNumberInfoList().get(0).getStartPC());
        assertEquals(3, codeAttribute.getLineNumberInfoList().get(0).getLineNumber());
    }
}