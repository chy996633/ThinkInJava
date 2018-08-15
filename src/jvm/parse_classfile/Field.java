package jvm.parse_classfile;

import java.util.HashMap;
import java.util.List;

public class Field {

    String fieldAccessFlag;

    Integer nameIndex;

    Integer descriptorIndex;

    Integer attrCount;

    List<String> attrList;

    HashMap<Integer, Constant> constantPool;

    HashMap<String, String> descriptorParseMap = new HashMap<>();

    {
        descriptorParseMap.put("I", "int");
        descriptorParseMap.put("B", "byte");
        descriptorParseMap.put("C", "char");
        descriptorParseMap.put("F", "float");
        descriptorParseMap.put("D", "double");
        descriptorParseMap.put("J", "long");
        descriptorParseMap.put("S", "short");
        descriptorParseMap.put("Z", "boolean");
        descriptorParseMap.put("V", "void");
    }

    public Field(String fieldAccessFlag, Integer nameIndex, Integer descriptorIndex,
            Integer attrCount, HashMap<Integer, Constant> constantPool, List<String> attrList) {
        this.fieldAccessFlag = fieldAccessFlag;
        this.nameIndex = nameIndex;
        this.descriptorIndex = descriptorIndex;
        this.attrCount = attrCount;
        this.constantPool = constantPool;
        this.attrList = attrList;
    }

    @Override
    public String toString() {
        return fieldAccessFlag + " " + getDescriptor() + " "
                + constantPool
                .get(nameIndex);
    }

    public String getDescriptor() {
        String constantStr = constantPool.get(descriptorIndex).toString();
        //fit both method and field
        String parsedResult = descriptorParseMap.get(String.valueOf(constantStr.charAt(constantStr.length() - 1)));
        return parsedResult == null
                // object type, like Ljava/String/Object
                ? constantPool.get(descriptorIndex).toString()
                //basic type
                : parsedResult;

    }


}
