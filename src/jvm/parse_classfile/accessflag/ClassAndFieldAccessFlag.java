package jvm.parse_classfile.accessflag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import jvm.parse_classfile.U2;

public class ClassAndFieldAccessFlag {

    static int ACC_PUBLIC = 0x0001;

    static int ACC_PRIVATE = 0x0002;

    static int ACC_PROTECTED = 0x0004;

    static int ACC_STATIC = 0x0008;

    static int ACC_FINAL = 0x0010;

    static int ACC_SUPER = 0x0020;

    static int ACC_SYNCHRONIZED = 0x0020;

    static int ACC_VOLATILE = 0x0040;

    static int ACC_BRIDGE = 0x0040;

    static int ACC_TRANSIENT = 0x0080;

    static int ACC_VARARGS = 0x0080;

    static int ACC_NATIVE = 0x0100;

    static int ACC_INTERFACE = 0x0200;

    static int ACC_ABSTRACT = 0x0400;

    static int ACC_STRICTFP = 0x0800;

    static int ACC_SYNTHETIC = 0x1000;

    static int ACC_ANNOTATION = 0x2000;

    static int ACC_ENUM = 0x4000;

    public static String getFlagName(byte[] flag) {
        assert flag.length == 2;
        ArrayList<String> flagArray = new ArrayList<>();
        //TODO use tuple with list
        Map<Integer, String> flagMap = new TreeMap();
        flagMap.putIfAbsent(ACC_PUBLIC, "public");
        flagMap.putIfAbsent(ACC_PRIVATE, "private");
        flagMap.putIfAbsent(ACC_PROTECTED, "protected");
        flagMap.putIfAbsent(ACC_FINAL, "final");
        flagMap.putIfAbsent(ACC_SUPER, "super");
        flagMap.putIfAbsent(ACC_STATIC, "static");
        flagMap.putIfAbsent(ACC_VOLATILE, "volatile");
        flagMap.putIfAbsent(ACC_TRANSIENT, "transient");
        flagMap.putIfAbsent(ACC_INTERFACE, "interface");
        flagMap.putIfAbsent(ACC_ABSTRACT, "abstract");
        flagMap.putIfAbsent(ACC_SYNTHETIC, "synthetic");
        flagMap.putIfAbsent(ACC_ANNOTATION, "annotation");
        flagMap.putIfAbsent(ACC_ENUM, "enum");

        flagMap.forEach((flagNum, flagStr) -> {
            if ((U2.byteToShort(flag) & flagNum ) != 0) {
                flagArray.add(flagStr);
            }
        });
        return flagArray.stream().reduce((accumulate, flagStr) -> accumulate + " " + flagStr)
                .orElse("");
    }

    public static String getMethodFlagName(byte[] flag) {
        assert flag.length == 2;
        ArrayList<String> flagArray = new ArrayList<>();
        Map<Integer, String> flagMap = new TreeMap();

        flagMap.putIfAbsent(ACC_PUBLIC, "public");
        flagMap.putIfAbsent(ACC_FINAL, "final");
        flagMap.putIfAbsent(ACC_SYNCHRONIZED, "synchronized");
        flagMap.putIfAbsent(ACC_PRIVATE, "private");
        flagMap.putIfAbsent(ACC_PROTECTED, "protected");
        flagMap.putIfAbsent(ACC_STATIC, "static");
        flagMap.putIfAbsent(ACC_BRIDGE, "bridge");
        flagMap.putIfAbsent(ACC_VARARGS, "varargs");
        flagMap.putIfAbsent(ACC_ABSTRACT, "abstract");
        flagMap.putIfAbsent(ACC_SYNTHETIC, "synthetic");
        flagMap.putIfAbsent(ACC_STRICTFP, "strictfp");
        flagMap.putIfAbsent(ACC_NATIVE, "native");

        flagMap.forEach((flagNum, flagStr) -> {
            if ((U2.byteToShort(flag) & flagNum ) != 0) {
                flagArray.add(flagStr);
            }
        });
        return flagArray.stream().reduce((accumulate, flagStr) -> accumulate + " " + flagStr)
                .orElse("");
    }

}
