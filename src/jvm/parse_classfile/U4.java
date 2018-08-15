package jvm.parse_classfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.xml.bind.DatatypeConverter;

public class U4 {

    public static int read(FileInputStream fileInputStream) {
        byte[] u4 = new byte[4];
        try {
            fileInputStream.read(u4);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert u4.length == 4;
        return ((u4[0] & 0xff) >> 12) + ((u4[1] & 0xff) >> 8) + ((u4[2] & 0xff) >> 4) + u4[3] & 0xff;
    }

    public static String readString(FileInputStream fileInputStream) {
        byte[] u4 = new byte[4];
        try {
            fileInputStream.read(u4);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert u4.length == 4;
        return DatatypeConverter.printHexBinary(u4);
    }
}
