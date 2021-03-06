package jvm.parse_classfile.constant;

import java.io.FileInputStream;
import java.util.HashMap;
import jvm.parse_classfile.ParseClass;
import jvm.parse_classfile.U2;

public class ConstantMethodRefInfo implements Constant {

    int classInfoIndex;

    int nameAndTypeIndex;

    private HashMap<Integer, Constant> constantMap;

    public ConstantMethodRefInfo(HashMap<Integer, Constant> constantMap) {
        this.constantMap = constantMap;
    }

    @Override
    public void readFrom(FileInputStream fileInputStream) {
        classInfoIndex = U2.read(fileInputStream);
        nameAndTypeIndex = U2.read(fileInputStream);
    }

    @Override
    public Integer getTag() {
        return 10;
    }

    @Override
    public String toString() {
        return constantMap.get(classInfoIndex).toString() + " " + constantMap.get(nameAndTypeIndex).toString();
    }
}
