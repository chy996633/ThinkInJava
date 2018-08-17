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
        int num = 0;
        for (int i = 0; i< u4.length; i++){
            num <<= 8;
            num |= (u4[i] & 0xff);
        }
        return num;
    }

    public static String readString(FileInputStream fileInputStream) {
        byte[] u4 = new byte[4];
        try {
            fileInputStream.read(u4);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return DatatypeConverter.printHexBinary(u4);
    }
}
