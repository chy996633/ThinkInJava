package jvm.parse_classfile;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import org.junit.Test;

public class ParseClassTest {

    @Test
    public void parseClassFile() {
        ParseClass parseClass = new ParseClass(
                "/home/backstop-samuel/git_code/ThinkInJava/src/bytecode/TestClass.class");
        try {
            String result = parseClass.parseClassFile();
            assertEquals("magic: CAFEBABE\n"
                    + "minor_version: 0\n"
                    + "major_version: 50\n"
                    + "constant_pool_count: 18\n"
                    + "constant :\n"
                    + "{1=jvm.parse_classfile.constant.ConstantMethodRefInfo@73c6c3b2, 2=jvm.parse_classfile.constant.ConstantFieldRefInfo@48533e64, 3=bytecode/TestClass, 4=java/lang/Object, 5=m, 6=I, 7=<init>, 8=()V, 9=Code, 10=LineNumberTable, 11=inc, 12=()I, 13=SourceFile, 14=TestClass.java, 15=jvm.parse_classfile.constant.ConstantNameAndTypeInfo@64a294a6, 16=jvm.parse_classfile.constant.ConstantNameAndTypeInfo@7e0b37bc, 17=bytecode/TestClass, 18=java/lang/Object}\n"
                    + "class accessFlag: public super\n"
                    + "class: bytecode/TestClass\n"
                    + "super class: java/lang/Object\n"
                    + "interfaces: []\n"
                    + "field: \n"
                    + "private int m\n"
                    + "\n"
                    + " LineNumberTable startPC: 0 lineNumber: 3 \n"
                    + "code index: 0x2A 0xB7 0x00 0x01 0xB1\n"
                    + "methods: public void <init>\n"
                    + "\n"
                    + " LineNumberTable startPC: 0 lineNumber: 8 \n"
                    + "code index: 0x2A 0xB4 0x00 0x02 0x04 0x60 0xAC\n"
                    + "methods: public int inc\n", result);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}