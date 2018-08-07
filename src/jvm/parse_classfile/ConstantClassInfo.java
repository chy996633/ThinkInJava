package jvm.parse_classfile;

import java.io.FileInputStream;

public class ConstantClassInfo implements Constant {

    int index;

    @Override
    public void readFrom(FileInputStream fileInputStream) {
        index = ParseClass.byteToShort(ParseClass.readU2(fileInputStream));
    }

    @Override
    public Integer getTag() {
        return 7;
    }
}
