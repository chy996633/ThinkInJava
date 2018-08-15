package jvm.parse_classfile.constant;

import java.io.FileInputStream;
import jvm.parse_classfile.ParseClass;
import jvm.parse_classfile.U2;

public class ConstantNameAndTypeInfo implements Constant {

    int nameIndex;

    int descIndex;

    @Override
    public void readFrom(FileInputStream fileInputStream) {
        nameIndex = U2.read(fileInputStream);
        descIndex = U2.read(fileInputStream);
    }

    @Override
    public Integer getTag() {
        return 12;
    }
}
