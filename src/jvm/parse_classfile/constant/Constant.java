package jvm.parse_classfile.constant;

import java.io.FileInputStream;

public interface Constant {

    void readFrom(FileInputStream fileInputStream);

    Integer getTag();

}
