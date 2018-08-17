package jvm.parse_classfile;

import java.util.ArrayList;

public class Code extends Attribute {

    private int maxStack;
    private int maxLocals;
    private int codeLength;
    private ArrayList<String> codeStrList;
    private int exceptionTableLength;
    private ArrayList<ExceptionTable> exceptionTableArrayList;
    private int attributesLength;
    private ArrayList<Attribute> attributes;

    public void setMaxStack(int maxStack) {
        this.maxStack = maxStack;
    }

    public void setMaxLocals(int maxLocals) {
        this.maxLocals = maxLocals;
    }

    public void setCodeLength(int codeLength) {
        this.codeLength = codeLength;
    }

    public void setCodeStrList(ArrayList<String> codeStrList) {
        this.codeStrList = codeStrList;
    }

    public void setExceptionTableLength(int exceptionTableLength) {
        this.exceptionTableLength = exceptionTableLength;
    }

    public void setExceptionTableArrayList(
            ArrayList<ExceptionTable> exceptionTableArrayList) {
        this.exceptionTableArrayList = exceptionTableArrayList;
    }

    public void setAttributesLength(int attributesLength) {
        this.attributesLength = attributesLength;
    }

    public void setAttributes(ArrayList<Attribute> attributes) {
        this.attributes = attributes;
    }

    public int getMaxStack() {
        return maxStack;
    }

    public int getMaxLocals() {
        return maxLocals;
    }

    public int getCodeLength() {
        return codeLength;
    }

    public ArrayList<String> getCodeStrList() {
        return codeStrList;
    }

    public int getExceptionTableLength() {
        return exceptionTableLength;
    }

    public ArrayList<ExceptionTable> getExceptionTableArrayList() {
        return exceptionTableArrayList;
    }

    public int getAttributesLength() {
        return attributesLength;
    }

    public ArrayList<Attribute> getAttributes() {
        return attributes;
    }

    public void addAttribute(Attribute attribute) {
        if (attributes == null) {
            attributes = new ArrayList<>();
        }
        attributes.add(attribute);
    }

    public void addCodeStr(String byteCode) {
        if (codeStrList == null) {
            codeStrList = new ArrayList<>();
        }
        codeStrList.add(byteCode);
    }
}
