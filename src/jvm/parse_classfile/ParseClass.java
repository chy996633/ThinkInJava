package jvm.parse_classfile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import javax.persistence.Access;
import javax.xml.bind.DatatypeConverter;

public class ParseClass {

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(
                "/home/backstop-samuel/git_code/ThinkInJava/src/bytecode/TestClass.class");
        StringBuilder s = new StringBuilder();
        s.append("magic: ")
                .append(DatatypeConverter.printHexBinary(ParseClass.readU4(fileInputStream)))
                .append("\nminor_version: ")
                .append(ParseClass.byteToShort(ParseClass.readU2(fileInputStream)))
                .append("\nmajor_version: ")
                .append(ParseClass.byteToShort(ParseClass.readU2(fileInputStream)));

        Integer constantPoolCount = ParseClass.byteToShort(ParseClass.readU2(fileInputStream)) - 1;
        s.append("\nconstant_pool_count: ").append(constantPoolCount);

        HashMap<Integer, Constant> constantMap = new HashMap<>();
        for (int i = 0; i < constantPoolCount; i++) {
            int tag = ParseClass.readU1(fileInputStream)[0];
            Constant c = null;
            switch (tag) {
                case 10:
                    c = new ConstantMethodRefInfo();
                    break;
                case 9:
                    c = new ConstantFieldRefInfo();
                    break;
                case 1:
                    c = new ConstantUTF8Info();
                    break;
                case 2:
                    c = new ConstantIntegerInfo();
                    break;
                case 7:
                    c = new ConstantClassInfo();
                    break;
                case 12:
                    c = new ConstantNameAndTypeInfo();
                    break;
                default:
                    System.out.println("unfound tag: " + tag);
            }
            c.readFrom(fileInputStream);
            constantMap.put(i, c);
        }

        String accessFlag = AccessFlag.getFlagName(ParseClass.readU2(fileInputStream));
        String klass = constantMap.get(ParseClass.byteToShort(ParseClass.readU2(fileInputStream))).toString();


        System.out.println(s);


    }

    public static byte[] readU1(FileInputStream fileInputStream) {
        byte[] u1 = new byte[1];
        try {
            fileInputStream.read(u1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return u1;
    }

    public static byte[] readU2(FileInputStream fileInputStream) {
        byte[] u2 = new byte[2];
        try {
            fileInputStream.read(u2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return u2;
    }

    public static byte[] readU4(FileInputStream fileInputStream) {
        byte[] u4 = new byte[4];
        try {
            fileInputStream.read(u4);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return u4;
    }

    public static int byteToShort(byte[] array) {
        assert array.length == 2;
        return (array[0] >> 4) + array[1];
    }

    public static int byteToInt(byte[] array) {
        assert array.length == 4;
        return (array[0] >> 12) + (array[1] >> 8) + (array[2] >> 4) + array[3];
    }


}
