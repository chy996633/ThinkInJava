package jvm.parse_classfile.constant;

import java.io.FileInputStream;
import jvm.parse_classfile.ParseClass;
import jvm.parse_classfile.U2;

public class ConstantMethodRefInfo implements Constant {

    int classInfoIndex;

    int nameAndTypeIndex;

    @Override
    public void readFrom(FileInputStream fileInputStream) {
        classInfoIndex = U2.read(fileInputStream);
        nameAndTypeIndex = U2.read(fileInputStream);
    }

    @Override
    public Integer getTag() {
        return 10;
    }
}
