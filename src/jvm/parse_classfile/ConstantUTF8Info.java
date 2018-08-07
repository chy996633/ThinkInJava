package jvm.parse_classfile;

import java.io.FileInputStream;
import java.io.IOException;
import javax.xml.bind.DatatypeConverter;

public class ConstantUTF8Info implements Constant {

    int length;

    byte[] chars;

    @Override
    public void readFrom(FileInputStream fileInputStream) {
        length = ParseClass.byteToShort(ParseClass.readU2(fileInputStream));
        chars = new byte[length];
        try {
            fileInputStream.read(chars);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Integer getTag() {
        return 1;
    }

    @Override
    public String toString() {
        return chars == null ? "" : byteToString(chars);
    }

    public String byteToString(byte[] array){
        StringBuilder s = new StringBuilder();
        for (byte b : array) {
            s.append((char) b);
        }
        return s.toString();
    }
}
