package jvm.parse_classfile.constant;

import java.io.FileInputStream;
import java.util.HashMap;
import jvm.parse_classfile.ParseClass;
import jvm.parse_classfile.U2;

public class ConstantNameAndTypeInfo implements Constant {

    int nameIndex;

    int descIndex;

    private HashMap<Integer, Constant> constantMap;

    public ConstantNameAndTypeInfo(HashMap<Integer, Constant> constantMap) {
        this.constantMap = constantMap;
    }

    @Override
    public void readFrom(FileInputStream fileInputStream) {
        nameIndex = U2.read(fileInputStream);
        descIndex = U2.read(fileInputStream);
    }

    @Override
    public Integer getTag() {
        return 12;
    }

    @Override
    public String toString() {
        return constantMap.get(nameIndex).toString() + " " + constantMap.get(descIndex).toString();
    }
}
