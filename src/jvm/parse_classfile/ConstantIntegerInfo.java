package jvm.parse_classfile;

import java.io.FileInputStream;

public class ConstantIntegerInfo implements Constant {

    int value;

    @Override
    public void readFrom(FileInputStream fileInputStream) {
        value = ParseClass.byteToInt(ParseClass.readU4(fileInputStream));
    }

    @Override
    public Integer getTag() {
        return 2;
    }
}
