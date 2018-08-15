package jvm.parse_classfile.constant;

import java.io.FileInputStream;
import java.util.HashMap;
import jvm.parse_classfile.ParseClass;
import jvm.parse_classfile.U2;

public class ConstantClassInfo implements Constant {

    int index;
    HashMap<Integer, Constant> constantMap;

    public ConstantClassInfo(HashMap<Integer, Constant> constantMap) {
        this.constantMap = constantMap;
    }

    @Override
    public void readFrom(FileInputStream fileInputStream) {
        index = U2.read(fileInputStream);
    }

    @Override
    public Integer getTag() {
        return 7;
    }

    @Override
    public String toString() {
        return constantMap.get(index).toString();
    }
}
