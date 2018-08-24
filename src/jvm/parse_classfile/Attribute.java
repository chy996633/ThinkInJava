package jvm.parse_classfile;

import java.io.FileInputStream;
import java.util.List;

public abstract class Attribute {

    int attrNameIndex;
    int attrLength;

    public Attribute(int attrNameIndex, int attrLength) {
        this.attrNameIndex = attrNameIndex;
        this.attrLength = attrLength;
    }

    public Attribute() {
    }

    public void setAttrNameIndex(int attrNameIndex) {
        this.attrNameIndex = attrNameIndex;
    }

    public void setAttrLength(int attrLength) {
        this.attrLength = attrLength;
    }

    public abstract void read(FileInputStream fileInputStream);
}
