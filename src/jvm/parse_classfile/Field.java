package jvm.parse_classfile;

import java.util.HashMap;

public class Field {

    String fieldAccessFlag;

    Integer nameIndex;

    Integer descriptorIndex;

    Integer attrCount;

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
            Integer attrCount, HashMap<Integer, Constant> constantPool) {
        this.fieldAccessFlag = fieldAccessFlag;
        this.nameIndex = nameIndex;
        this.descriptorIndex = descriptorIndex;
        this.attrCount = attrCount;
        this.constantPool = constantPool;
    }

    @Override
    public String toString() {
        return fieldAccessFlag + " " + getDescriptor() + " "
                + constantPool
                .get(nameIndex);
    }

    public String getDescriptor() {
        String parsedResult = descriptorParseMap.get(constantPool.get(descriptorIndex).toString());
        return parsedResult == null
                // object type, like Ljava/String/Object
                ? constantPool.get(descriptorIndex).toString()
                //basic type
                : parsedResult;

    }


}
