package jvm.parse_classfile;

import java.io.FileInputStream;
import java.io.IOException;

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
        return ((array[0] & 0xff) >> 4) + array[1] & 0xff;
    }
}
