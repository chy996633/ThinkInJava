package jvm.parse_classfile;

import java.io.FileInputStream;
import java.util.HashMap;

public class ConstantStringInfo implements Constant {

    int index;
    String str;
    HashMap<Integer, Constant> constantMap;

    public ConstantStringInfo(HashMap<Integer, Constant> constantMap) {
        this.constantMap = constantMap;
    }

    @Override
    public void readFrom(FileInputStream fileInputStream) {
        index = ParseClass.byteToShort(ParseClass.readU2(fileInputStream));
        str = constantMap.get(index).toString();
    }

    @Override
    public Integer getTag() {
        return 8;
    }
}
