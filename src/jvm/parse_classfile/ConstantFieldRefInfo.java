package jvm.parse_classfile;

import java.io.FileInputStream;

public class ConstantFieldRefInfo implements Constant {

    int classInfoIndex;

    int nameAndTypeIndex;

    @Override
    public void readFrom(FileInputStream fileInputStream) {
        classInfoIndex = ParseClass.byteToShort(ParseClass.readU2(fileInputStream));
        nameAndTypeIndex = ParseClass.byteToShort(ParseClass.readU2(fileInputStream));
    }

    @Override
    public Integer getTag() {
        return 9;
    }
}
