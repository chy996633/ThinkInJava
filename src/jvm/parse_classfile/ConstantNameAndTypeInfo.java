package jvm.parse_classfile;

import java.io.FileInputStream;

public class ConstantNameAndTypeInfo implements Constant {

    int nameIndex;

    int descIndex;

    @Override
    public void readFrom(FileInputStream fileInputStream) {
        nameIndex = ParseClass.byteToShort(ParseClass.readU2(fileInputStream));
        descIndex = ParseClass.byteToShort(ParseClass.readU2(fileInputStream));
    }

    @Override
    public Integer getTag() {
        return 12;
    }
}
