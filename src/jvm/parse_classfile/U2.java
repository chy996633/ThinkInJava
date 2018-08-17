package jvm.parse_classfile;

import java.io.FileInputStream;
import java.io.IOException;
import javax.xml.bind.DatatypeConverter;

public class U2 {

    public static byte[] readU2(FileInputStream fileInputStream) {
        byte[] u2 = new byte[2];
        try {
            fileInputStream.read(u2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return u2;
    }

    public static int read(FileInputStream fileInputStream) {
        byte[] array = readU2(fileInputStream);
        return byteToShort(array);
    }

    public static int byteToShort(byte[] array) {
        int num = 0;
        for (int i = 0; i< array.length; i++){
            num <<= 8;
            num |= (array[i] & 0xff);
        }
        return num;
    }

    public static String readString(FileInputStream fileInputStream) {
        byte[] u2 = new byte[2];
        try {
            fileInputStream.read(u2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return DatatypeConverter.printHexBinary(u2);
    }

}
