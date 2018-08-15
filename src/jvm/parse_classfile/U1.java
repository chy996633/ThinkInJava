package jvm.parse_classfile;

import java.io.FileInputStream;
import java.io.IOException;

public class U1 {

    public static byte[] read(FileInputStream fileInputStream) {
        byte[] u1 = new byte[1];
        try {
            fileInputStream.read(u1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return u1;
    }

    public static int readInt(FileInputStream fileInputStream) {
        byte[] u1 = new byte[1];
        try {
            fileInputStream.read(u1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return u1[0] & 0xff;
    }
}
