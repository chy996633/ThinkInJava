package jvm.parse_classfile;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import org.junit.Test;

public class ParseClassTest {

    @Test
    public void parseClassFile() {
        ParseClass parseClass = new ParseClass();
        try {
            String result = parseClass.parseClassFile();
            assertEquals("magic: CAFEBABE\n"
                    + "minor_version: 0\n"
                    + "major_version: 50\n"
                    + "constant_pool_count: 18\n"
                    + "class accessFlag: public super \n"
                    + "class: bytecode/TestClass\n"
                    + "super class: java/lang/Object\n"
                    + "interfaces: []\n"
                    + "field: private  int m\n"
                    + "\n"
                    + " LineNumberTable startPC: 0 lineNumber: 3 \n"
                    + "code index: 0x2A 0xB7 0x00 0x01 0xB1\n"
                    + "methods: public  void <init>\n"
                    + "\n"
                    + " LineNumberTable startPC: 0 lineNumber: 8 \n"
                    + "code index: 0x2A 0xB4 0x00 0x02 0x04 0x60 0xAC\n"
                    + "methods: public  int inc\n", result);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}