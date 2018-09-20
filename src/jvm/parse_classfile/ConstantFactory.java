package jvm.parse_classfile;

import java.util.HashMap;
import jvm.parse_classfile.constant.Constant;
import jvm.parse_classfile.constant.ConstantClassInfo;
import jvm.parse_classfile.constant.ConstantFieldRefInfo;
import jvm.parse_classfile.constant.ConstantIntegerInfo;
import jvm.parse_classfile.constant.ConstantMethodRefInfo;
import jvm.parse_classfile.constant.ConstantNameAndTypeInfo;
import jvm.parse_classfile.constant.ConstantStringInfo;
import jvm.parse_classfile.constant.ConstantUTF8Info;

public class ConstantFactory {


    public static Constant getConstant(int tag,
            HashMap<Integer, Constant> constantMap) {
        Constant c = null;
        switch (tag) {
            case 10:
                c = new ConstantMethodRefInfo(constantMap);
                break;
            case 9:
                c = new ConstantFieldRefInfo(constantMap);
                break;
            case 8:
                c = new ConstantStringInfo(constantMap);
                break;
            case 1:
                c = new ConstantUTF8Info();
                break;
            case 2:
                c = new ConstantIntegerInfo();
                break;
            case 7:
                c = new ConstantClassInfo(constantMap);
                break;
            case 12:
                c = new ConstantNameAndTypeInfo(constantMap);
                break;
            default:
                System.out.println("unfound tag: " + tag);
        }
        return c;
    }
}
