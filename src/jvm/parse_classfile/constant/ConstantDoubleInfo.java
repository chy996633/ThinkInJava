package jvm.parse_classfile.constant;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ConstantDoubleInfo implements Constant {

    private Double value;

    @Override
    public void readFrom(FileInputStream fileInputStream) {
        byte[] u8 = new byte[8];
        try {
            fileInputStream.read(u8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        DataInputStream dis=new DataInputStream(new ByteArrayInputStream(u8));
        try {
            value =dis.readDouble();
            dis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Integer getTag() {
        return 6;
    }

    @Override
    public String toString() {
        return "CONSTANT_Double_info = " + value;
    }
}
