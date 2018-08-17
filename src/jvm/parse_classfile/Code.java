package jvm.parse_classfile;

import java.util.ArrayList;

public class Code extends Attribute {

    private int maxStack;
    private int maxLocals;
    private int codeLength;
    private ArrayList<String> codeList;
    private int exceptionTableLength;
    private ArrayList<ExceptionTable> exceptionTableArrayList;
    private int attributesLength;
    private ArrayList<Attribute> attributes;

}
