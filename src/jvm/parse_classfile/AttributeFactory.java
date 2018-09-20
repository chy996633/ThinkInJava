package jvm.parse_classfile;

import com.sun.org.apache.xpath.internal.SourceTree;
import java.util.ArrayList;
import java.util.HashMap;
import javax.xml.bind.DatatypeConverter;
import jvm.parse_classfile.constant.Constant;

public class AttributeFactory {

    public static Attribute getInstance(String attribute,
            HashMap<Integer, Constant> constantMap) {
        Attribute attr = null;
        switch (attribute) {
            case "Code":
                Code code = new Code();
                code.setConstantMap(constantMap);
                attr = code;
                break;
            case "Exceptions":

                break;
            case "ConstantValue":

                break;
            default:
                System.out.println("not found attr: " + attribute);

        }
        return attr;
    }
}
