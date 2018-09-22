package jvm.parse_classfile;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import org.junit.Test;

public class ParseClassTest {

    @Test
    public void parseClassFile() {
        ParseClass parseClass = new ParseClass(
                "/home/backstop-samuel/git_code/ThinkInJava/bin/bytecode/TestClass.class");
        try {
            String result = parseClass.parseClassFile();
            assertEquals("magic: CAFEBABE\n"
                    + "minor_version: 0\n"
                    + "major_version: 52\n"
                    + "constant_pool_count: 21\n"
                    + "constant :\n"
                    + "{1=java/lang/Object <init> ()V, 2=bytecode/TestClass m I, 3=bytecode/TestClass, 4=java/lang/Object, 5=m, 6=I, 7=<init>, 8=()V, 9=Code, 10=LineNumberTable, 11=LocalVariableTable, 12=this, 13=Lbytecode/TestClass;, 14=inc, 15=()I, 16=SourceFile, 17=TestClass.java, 18=<init> ()V, 19=m I, 20=bytecode/TestClass, 21=java/lang/Object}\n"
                    + "class accessFlag: public super\n"
                    + "class: bytecode/TestClass\n"
                    + "super class: java/lang/Object\n"
                    + "interfaces: []\n"
                    + "field: \n"
                    + "private int m\n"
                    + "\n"
                    + "method: \n"
                    + "public void <init> \n"
                    + "\n"
                    + "LineNumberTable startPC: 0 lineNumber: 3 \n"
                    + "startPC: 0 length: 5 name: this descriptor: Lbytecode/TestClass;\n"
                    + "Code: 0x2A 0xB7 0x00 0x01 0xB1\n"
                    + "\n"
                    + "public int inc \n"
                    + "\n"
                    + "LineNumberTable startPC: 0 lineNumber: 8 \n"
                    + "startPC: 0 length: 7 name: this descriptor: Lbytecode/TestClass;\n"
                    + "Code: 0x2A 0xB4 0x00 0x02 0x04 0x60 0xAC\n\n", result);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void parseAnotherClassFile() {
        ParseClass parseClass = new ParseClass(
                "/home/backstop-samuel/git_code/ThinkInJava/bin/jvm/JavaVMStackSOE.class");
        try {
            String result = parseClass.parseClassFile();
            assertEquals("magic: CAFEBABE\n"
                    + "minor_version: 0\n"
                    + "major_version: 52\n"
                    + "constant_pool_count: 64\n"
                    + "constant :\n"
                    + "{1=java/lang/Object <init> ()V, 2=jvm/JavaVMStackSOE length I, 3=jvm/JavaVMStackSOE, 4=jvm/JavaVMStackSOE <init> ()V, 5=jvm/JavaVMStackSOE stackLeak ()V, 6=java/lang/Throwable, 7=java/lang/System out Ljava/io/PrintStream;, 8=java/lang/StringBuilder, 9=java/lang/StringBuilder <init> ()V, 10=stack max length: , 11=java/lang/StringBuilder append (Ljava/lang/String;)Ljava/lang/StringBuilder;, 12=java/lang/StringBuilder append (I)Ljava/lang/StringBuilder;, 13=java/lang/StringBuilder toString ()Ljava/lang/String;, 14=java/io/PrintStream println (Ljava/lang/String;)V, 15=java/lang/Object, 16=length, 17=I, 18=<init>, 19=()V, 20=Code, 21=LineNumberTable, 22=LocalVariableTable, 23=this, 24=Ljvm/JavaVMStackSOE;, 25=main, 26=([Ljava/lang/String;)V, 27=e, 28=Ljava/lang/Throwable;, 29=args, 30=[Ljava/lang/String;, 31=j, 32=StackMapTable, 33=[Ljava/lang/String;, 34=jvm/JavaVMStackSOE, 35=java/lang/Throwable, 36=stackLeak, 37=SourceFile, 38=JavaVMStackSOE.java, 39=<init> ()V, 40=length I, 41=jvm/JavaVMStackSOE, 42=stackLeak ()V, 43=java/lang/Throwable, 44=java/lang/System, 45=out Ljava/io/PrintStream;, 46=java/lang/StringBuilder, 47=stack max length: , 48=append (Ljava/lang/String;)Ljava/lang/StringBuilder;, 49=append (I)Ljava/lang/StringBuilder;, 50=toString ()Ljava/lang/String;, 51=java/io/PrintStream, 52=println (Ljava/lang/String;)V, 53=java/lang/Object, 54=java/lang/System, 55=out, 56=Ljava/io/PrintStream;, 57=append, 58=(Ljava/lang/String;)Ljava/lang/StringBuilder;, 59=(I)Ljava/lang/StringBuilder;, 60=toString, 61=()Ljava/lang/String;, 62=java/io/PrintStream, 63=println, 64=(Ljava/lang/String;)V}\n"
                    + "class accessFlag: public super\n"
                    + "class: jvm/JavaVMStackSOE\n"
                    + "super class: java/lang/Object\n"
                    + "interfaces: []\n"
                    + "field: \n"
                    + "public int length\n"
                    + "\nmethod: \n"
                    + "public void <init> \n"
                    + "\n"
                    + "LineNumberTable startPC: 0 lineNumber: 6 startPC: 4 lineNumber: 8 \n"
                    + "startPC: 0 length: 10 name: this descriptor: Ljvm/JavaVMStackSOE;\n"
                    + "Code: 0x2A 0xB7 0x00 0x01 0x2A 0x03 0xB5 0x00 0x02 0xB1\n"
                    + "\n"
                    + "public static void main \n"
                    + "\n"
                    + "LineNumberTable startPC: 0 lineNumber: 11 startPC: 8 lineNumber: 13 startPC: 12 lineNumber: 18 startPC: 15 lineNumber: 15 startPC: 16 lineNumber: 16 startPC: 44 lineNumber: 17 startPC: 46 lineNumber: 19 \n"
                    + "startPC: 16 length: 30 name: e descriptor: Ljava/lang/Throwable;startPC: 0 length: 47 name: args descriptor: [Ljava/lang/String;startPC: 8 length: 39 name: j descriptor: Ljvm/JavaVMStackSOE;\n"
                    + "jvm.parse_classfile.CodeAttribute$StackMapTable$FullFrame /** 255 /jvm.parse_classfile.CodeAttribute$StackMapTable$SameFrame /** 30 /\n"
                    + "Code: 0xBB 0x00 0x03 0x59 0xB7 0x00 0x04 0x4C 0x2B 0xB7 0x00 0x05 0xA7 0x00 0x22 0x4D 0xB2 0x00 0x07 0xBB 0x00 0x08 0x59 0xB7 0x00 0x09 0x12 0x0A 0xB6 0x00 0x0B 0x2B 0xB4 0x00 0x02 0xB6 0x00 0x0C 0xB6 0x00 0x0D 0xB6 0x00 0x0E 0x2C 0xBF 0xB1\n"
                    + "\n"
                    + "private void stackLeak \n"
                    + "\n"
                    + "LineNumberTable startPC: 0 lineNumber: 22 startPC: 10 lineNumber: 23 startPC: 14 lineNumber: 24 \n"
                    + "startPC: 0 length: 15 name: this descriptor: Ljvm/JavaVMStackSOE;\n"
                    + "Code: 0x2A 0x59 0xB4 0x00 0x02 0x04 0x60 0xB5 0x00 0x02 0x2A 0xB7 0x00 0x05 0xB1\n"
                    + "\n", result);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
