package jvm.parse_classfile.constant;

import java.io.FileInputStream;
import java.io.IOException;

public class ConstantIntegerInfo implements Constant {

    int value;

    @Override
    public void readFrom(FileInputStream fileInputStream) {
        byte[] u4 = new byte[4];
        try {
            fileInputStream.read(u4);
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] array = u4;
        assert array.length == 4;
        value = ((array[0] & 0xff) >> 12) + ((array[1] & 0xff) >> 8) + ((array[2] & 0xff) >> 4)
                + array[3] & 0xff;
    }

    @Override
    public Integer getTag() {
        return 3;
    }

    @Override
    public String toString() {
        return "CONSTANT_Integer_info = " + value;
    }
}
