package jvm.parse_classfile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jvm.parse_classfile.accessflag.ClassAndFieldAccessFlag;
import jvm.parse_classfile.constant.Constant;
import jvm.parse_classfile.field.Field;

public class ParseClass {

    private String magicCode;

    private HashMap<Integer, Constant> constantMap = new HashMap<>();
    private int minorVersion;
    private int majorVersion;
    private Integer constantPoolCount;
    private byte[] accessFlagIndex;
    private int thisClassIndex;
    private int superClassIndex;
    private int interfaceCount;
    private int fieldCount;
    private ArrayList<Field> fieldList = new ArrayList<>();
    private int methodCount;
    private ArrayList<Field> methodList;
    private String fileName;

    public ParseClass(String fileName) {
        this.fileName = fileName;
    }

    public String parseClassFile() throws Exception {
        FileInputStream fileInputStream = new FileInputStream(fileName);
        StringBuilder s = new StringBuilder();
        magicCode = U4.readString(fileInputStream);
        minorVersion = U2.read(fileInputStream);
        majorVersion = U2.read(fileInputStream);

        s.append("magic: ")
                .append(magicCode)
                .append("\nminor_version: ")
                .append(minorVersion)
                .append("\nmajor_version: ")
                .append(majorVersion);

        constantPoolCount = U2.read(fileInputStream) - 1;
        s.append("\nconstant_pool_count: ").append(constantPoolCount);

        for (int i = 0; i < constantPoolCount; i++) {
            int tag = U1.readInt(fileInputStream);
            Constant c = ConstantFactory.getConstant(tag, constantMap);
            c.readFrom(fileInputStream);
            constantMap.put(i + 1, c);
        }
        s.append("\nconstant :\n").append(constantMap.toString());

        accessFlagIndex = U2.readU2(fileInputStream);
        String accessFlag = ClassAndFieldAccessFlag.getFlagName(accessFlagIndex);
        thisClassIndex = U2.read(fileInputStream);
        String klass = constantMap.get(thisClassIndex)
                .toString();
        superClassIndex = U2.read(fileInputStream);
        String superKlass = constantMap
                .get(superClassIndex).toString();
        interfaceCount = U2.read(fileInputStream);
        List<String> interfaceNameList = new ArrayList<>();
        for (int i = 0; i < interfaceCount; i++) {
            interfaceNameList
                    .add(constantMap.get(U2.read(fileInputStream))
                            .toString());
        }

        s.append("\nclass accessFlag: ").append(accessFlag)
                .append("\nclass: ").append(klass)
                .append("\nsuper class: ").append(superKlass)
                .append("\ninterfaces: ").append(interfaceNameList.toString());

        fieldCount = U2.read(fileInputStream);
        s.append("\nfield: \n");
        for (int i = 0; i < fieldCount; i++) {
            String fieldAccessFlag = ClassAndFieldAccessFlag
                    .getFlagName(U2.readU2(fileInputStream));
            Integer nameIndex = U2.read(fileInputStream);
            Integer descriptorIndex = U2.read(fileInputStream);
            Integer attributeCount = U2.read(fileInputStream);
            List<String> attributeList = new ArrayList<>();
            for (int j = 0; j < attributeCount; j++) {
                Integer attributeIndex = U2.read(fileInputStream);
                String attribute = constantMap.get(attributeIndex).toString();
                attributeList.add(attribute);
            }
            Field field = new Field(fieldAccessFlag, nameIndex, descriptorIndex, attributeCount,
                    constantMap, attributeList);
            fieldList.add(field);
            s.append(field.toString()).append("\n");
        }

        methodCount = U2.read(fileInputStream);
        methodList = new ArrayList<>();
        s.append("\nmethod: \n");
        for (int i = 0; i < methodCount; i++) {
            String methodAccFlag = ClassAndFieldAccessFlag
                    .getMethodFlagName(U2.readU2(fileInputStream));
            Integer nameIndex = U2.read(fileInputStream);
            Integer descriptorIndex = U2.read(fileInputStream);
            Integer attributeCount = U2.read(fileInputStream);
            List<String> attributeList = new ArrayList<>();
            Field method = new Field(methodAccFlag, nameIndex, descriptorIndex, attributeCount,
                    constantMap, attributeList);
            methodList.add(method);
            s.append(method.toString()).append(" \n");
            for (int j = 0; j < attributeCount; j++) {
                Integer attributeIndex = U2.read(fileInputStream);
                String attribute = constantMap.get(attributeIndex).toString();
                int attrLength = U4.read(fileInputStream);
//                Attribute attr = AttributeFactory.getInstance(attribute, constantMap);
//                attr.read(fileInputStream);
                switch (attribute) {
                    case "Code":
                        Code code = new Code(attributeIndex, attrLength);
                        code.setConstantMap(constantMap);
                        code.read(fileInputStream);
                        s.append(code.getCodeAttrStr());
                        s.append("\n" + code.getCodeStr());
                        attributeList.add(attribute);
                        break;

                    default:
                        throw new Exception("unfound attr: " + attribute);

                }
            }
            s.append("\n\n");
        }

        System.out.println(s);
        return s.toString();
    }

    public static void main(String[] args) throws IOException {
//        ParseClass parseClass = new ParseClass("/home/backstop-samuel/git_code/ThinkInJava/src/bytecode/TestClass.class");
        ParseClass parseClass = new ParseClass("/home/backstop-samuel/git_code/ThinkInJava/bin/jvm/test/AllConstant.class");
        try {
            parseClass.parseClassFile();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
