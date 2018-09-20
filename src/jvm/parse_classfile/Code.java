package jvm.parse_classfile;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import javax.xml.bind.DatatypeConverter;
import jvm.parse_classfile.constant.Constant;

public class Code extends Attribute {

    private int maxStack;
    private int maxLocals;
    private int codeLength;
    private ArrayList<String> codeStrList = new ArrayList<>();
    private int exceptionTableLength;
    private ArrayList<ExceptionTable> exceptionTableArrayList = new ArrayList<>();
    private int attributesLength;
    private ArrayList<Attribute> attributes = new ArrayList<>();
    private HashMap<Integer, Constant> constantMap;
    private String codeStr = "code index:";

    public String getCodeAttrStr() {
        return codeAttrStr;
    }

    public void setCodeAttrStr(String codeAttrStr) {
        this.codeAttrStr = codeAttrStr;
    }

    private String codeAttrStr = "";


    public Code(int attrNameIndex, int attrLength) {
        super(attrNameIndex, attrLength);
    }

    public Code() {

    }

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

    public String getCodeStr() {
        return codeStr;
    }

    @Override
    public void read(FileInputStream fileInputStream) {
        maxStack = U2.read(fileInputStream);
        maxLocals = U2.read(fileInputStream);
        codeLength =  U4.read(fileInputStream);
        for (int k = 0; k < codeLength; k++) {
            String byteCode = "0x" + DatatypeConverter
                    .printHexBinary(U1.read(fileInputStream));
            addCodeStr(byteCode);
            codeStr += " " + byteCode;
        }
        exceptionTableLength = U2.read(fileInputStream);
        for (int k = 0; k < exceptionTableLength; k++) {
            Integer startPC = U2.read(fileInputStream);
            Integer endPC = U2.read(fileInputStream);
            Integer handlerPC = U2.read(fileInputStream);
            Integer catchTypeIndex = U2.read(fileInputStream);
            ExceptionTable exceptionTable = new ExceptionTable(startPC, endPC,
                    handlerPC, catchTypeIndex);
            exceptionTableArrayList.add(exceptionTable);
        }
        attributesLength = U2.read(fileInputStream);
        for (int k = 0; k < attributesLength; k++) {
            CodeAttribute codeAttribute = getCodeAttribute(fileInputStream);
            codeAttrStr += ("\n " + codeAttribute.toString());
        }
    }

    public void setConstantMap(HashMap<Integer, Constant> constantMap) {
        this.constantMap = constantMap;
    }

    public CodeAttribute getCodeAttribute(FileInputStream fileInputStream) {
        int attrNameOfCodeIndex = U2.read(fileInputStream);
        int attrOfCodeLength = U4.read(fileInputStream);
        CodeAttribute codeAttribute = new CodeAttribute(constantMap, attrNameOfCodeIndex, attrOfCodeLength);
        codeAttribute.read(fileInputStream);
        addAttribute(codeAttribute);
        return codeAttribute;
    }
}
