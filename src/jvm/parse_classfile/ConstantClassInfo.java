package jvm.parse_classfile;

import java.io.FileInputStream;
import java.util.HashMap;

public class ConstantClassInfo implements Constant {

    int index;
    HashMap<Integer, Constant> constantMap;

    public ConstantClassInfo(HashMap<Integer, Constant> constantMap) {
        this.constantMap = constantMap;
    }

    @Override
    public void readFrom(FileInputStream fileInputStream) {
        index = ParseClass.byteToShort(ParseClass.readU2(fileInputStream));
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
