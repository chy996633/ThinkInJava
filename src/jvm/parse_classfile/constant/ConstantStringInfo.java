package jvm.parse_classfile.constant;

import java.io.FileInputStream;
import java.util.HashMap;
import jvm.parse_classfile.ParseClass;
import jvm.parse_classfile.U2;

public class ConstantStringInfo implements Constant {

    int index;
    String str;
    HashMap<Integer, Constant> constantMap;

    public ConstantStringInfo(HashMap<Integer, Constant> constantMap) {
        this.constantMap = constantMap;
    }

    @Override
    public void readFrom(FileInputStream fileInputStream) {
        index = U2.read(fileInputStream);
//        if (index > constantMap.size()){
//            throw new IllegalArgumentException(getClass() + ": index "+ index +" out of constantMap");
//        }
//        str = constantMap.get(index).toString();
    }

    @Override
    public Integer getTag() {
        return 8;
    }

    @Override
    public String toString() {
        return constantMap.get(index).toString();
    }
}
