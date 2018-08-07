package jvm.parse_classfile;

public class AccessFlag {

    static int ACC_PUBLIC = 0x0001;

    static int ACC_FINAL = 0x0010;

    static int ACC_SUPER = 0x0020;

    static int ACC_INTERFACE = 0x0200;

    static int ACC_ABSTRACT = 0x0400;

    static int ACC_SYNTHETIC = 0x1000;

    static int ACC_ANNOTATION = 0x2000;

    static int ACC_ENUM = 0x4000;

    public static String getFlagName(byte[] flag) {
        assert flag.length == 2;
        String result = "";
        result += (ParseClass.byteToShort(flag) & ACC_PUBLIC) != 0 ? "ACC_PUBLIC|" : "" ;
        result += (ParseClass.byteToShort(flag) & ACC_FINAL) != 0 ? "ACC_FINAL|" : "" ;
        result += (ParseClass.byteToShort(flag) & ACC_SUPER) != 0 ? "ACC_SUPER|" : "" ;
        return result;
    }

}
