package jvm.parse_classfile.constant;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import jvm.parse_classfile.U4;

public class ConstantFloatInfo implements Constant {

    Float value;

    @Override
    public void readFrom(FileInputStream fileInputStream) {
        byte[] u4 = new byte[4];
        try {
            fileInputStream.read(u4);
        } catch (IOException e) {
            e.printStackTrace();
        }
        DataInputStream dis=new DataInputStream(new ByteArrayInputStream(u4));
        try {
            value =dis.readFloat();
            dis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Integer getTag() {
        return 4;
    }

    @Override
    public String toString() {
        return "CONSTANT_Float_info = " + value;
    }
}
