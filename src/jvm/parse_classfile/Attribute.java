package jvm.parse_classfile;

import java.util.List;

public class Attribute {

    int attrNameIndex;
    int attrLength;
    public List<Integer> info;

    public void setAttrNameIndex(int attrNameIndex) {
        this.attrNameIndex = attrNameIndex;
    }

    public void setAttrLength(int attrLength) {
        this.attrLength = attrLength;
    }
}
