package jvm.parse_classfile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.xml.bind.DatatypeConverter;
import jvm.parse_classfile.accessflag.ClassAndFieldAccessFlag;
import jvm.parse_classfile.constant.Constant;
import jvm.parse_classfile.constant.ConstantClassInfo;
import jvm.parse_classfile.constant.ConstantFieldRefInfo;
import jvm.parse_classfile.constant.ConstantIntegerInfo;
import jvm.parse_classfile.constant.ConstantMethodRefInfo;
import jvm.parse_classfile.constant.ConstantNameAndTypeInfo;
import jvm.parse_classfile.constant.ConstantStringInfo;
import jvm.parse_classfile.constant.ConstantUTF8Info;
import jvm.parse_classfile.field.Field;

public class ParseClass {

    private String magicCode;

    private HashMap<Integer, Constant> constantMap;
    private int minorVersion;
    private int majorVersion;
    private Integer constantPoolCount;
    private byte[] accessFlagIndex;
    private int thisClassIndex;
    private int superClassIndex;
    private int interfaceCount;
    private int fieldCount;
    private ArrayList<Field> fieldList;
    private int methodCount;
    private ArrayList<Field> methodList;

    public String parseClassFile() throws Exception {
        FileInputStream fileInputStream = new FileInputStream(
                "/home/backstop-samuel/git_code/ThinkInJava/src/bytecode/TestClass.class");
//                "/home/backstop-samuel/git_code/ThinkInJava/bin/jvm/parse_classfile/ClassAndFieldAccessFlag.class");
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

        constantMap = new HashMap<>();
        for (int i = 0; i < constantPoolCount; i++) {
            int tag = U1.readInt(fileInputStream);
            Constant c = null;
            switch (tag) {
                case 10:
                    c = new ConstantMethodRefInfo();
                    break;
                case 9:
                    c = new ConstantFieldRefInfo();
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
                    c = new ConstantNameAndTypeInfo();
                    break;
                default:
                    System.out.println("unfound tag: " + tag);
            }
            c.readFrom(fileInputStream);
            constantMap.put(i + 1, c);
        }

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
        fieldList = new ArrayList<>();
        s.append("\nfield: ");
        for (int i = 0; i < fieldCount; i++) {
            String fieldAccessFlag = ClassAndFieldAccessFlag
                    .getFlagName(U2.readU2(fileInputStream));
            Integer nameIndex = U2.read(fileInputStream);
            Integer descriptorIndex = U2.read(fileInputStream);
            Integer attributeCount = U2.read(fileInputStream);
            List<String> attributeList = new ArrayList<>();
            for (int j = 0; j < attributeCount; j++) {
                //TODO read attribute info
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
        for (int i = 0; i < methodCount; i++) {
            String methodAccFlag = ClassAndFieldAccessFlag
                    .getMethodFlagName(U2.readU2(fileInputStream));
            Integer nameIndex = U2.read(fileInputStream);
            Integer descriptorIndex = U2.read(fileInputStream);
            Integer attributeCount = U2.read(fileInputStream);
            List<String> attributeList = new ArrayList<>();
            for (int j = 0; j < attributeCount; j++) {
                Integer attributeIndex = U2.read(fileInputStream);
                String attribute = constantMap.get(attributeIndex).toString();
                switch (attribute) {
                    case "Code":
                        Code code = new Code();
                        code.setAttributesLength(U4.read(fileInputStream));
                        code.setMaxStack(U2.read(fileInputStream));
                        code.setMaxLocals(U2.read(fileInputStream));
                        code.setCodeLength(U4.read(fileInputStream));
                        String codeStr = "code index:";
                        for (int k = 0; k < code.getCodeLength(); k++) {
                            String byteCode = "0x" + DatatypeConverter
                                    .printHexBinary(U1.read(fileInputStream));
                            code.addCodeStr(byteCode);
                            codeStr += " " + byteCode;
                        }
                        code.setExceptionTableLength(U2.read(fileInputStream));
                        ArrayList<ExceptionTable> exceptionTableList = new ArrayList<>();
                        for (int k = 0; k < code.getExceptionTableLength(); k++) {
                            Integer startPC = U2.read(fileInputStream);
                            Integer endPC = U2.read(fileInputStream);
                            Integer handlerPC = U2.read(fileInputStream);
                            Integer catchTypeIndex = U2.read(fileInputStream);
                            ExceptionTable exceptionTable = new ExceptionTable(startPC, endPC,
                                    handlerPC, catchTypeIndex);
                            exceptionTableList.add(exceptionTable);
                        }
                        code.setExceptionTableArrayList(exceptionTableList);
                        code.setAttributesLength(U2.read(fileInputStream));
                        for (int k = 0; k < code.getAttributesLength(); k++) {
                            LineNumberTable lineNumberTable = new LineNumberTable(constantMap);
                            lineNumberTable.read(fileInputStream);
                            code.addAttribute(lineNumberTable);
                            s.append("\n " + lineNumberTable.toString());
                        }
                        s.append("\n" + codeStr);
                        attributeList.add(attribute);
                        break;

                    default:
                        throw new Exception("unfound attr: " + attribute);

                }
            }
            Field method = new Field(methodAccFlag, nameIndex, descriptorIndex, attributeCount,
                    constantMap, attributeList);
            methodList.add(method);
            s.append("\nmethods: " + method.toString()).append("\n");
        }

        System.out.println(s);
        return s.toString();
    }

    public static void main(String[] args) throws IOException {
        ParseClass parseClass = new ParseClass();
        try {
            parseClass.parseClassFile();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
