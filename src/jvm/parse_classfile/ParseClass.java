package jvm.parse_classfile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.xml.bind.DatatypeConverter;

public class ParseClass {

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(
                "/home/backstop-samuel/git_code/ThinkInJava/src/bytecode/TestClass.class");
//                "/home/backstop-samuel/git_code/ThinkInJava/bin/jvm/parse_classfile/ClassAndFieldAccessFlag.class");
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

        String accessFlag = ClassAndFieldAccessFlag.getFlagName(ParseClass.readU2(fileInputStream));
        String klass = constantMap.get(ParseClass.byteToShort(ParseClass.readU2(fileInputStream)))
                .toString();
        String superKlass = constantMap
                .get(ParseClass.byteToShort(ParseClass.readU2(fileInputStream))).toString();
        Integer interfaceCount = ParseClass.byteToShort(ParseClass.readU2(fileInputStream));
        List<String> interfaceNameList = new ArrayList<>();
        for (int i = 0; i < interfaceCount; i++) {
            interfaceNameList
                    .add(constantMap.get(ParseClass.byteToShort(ParseClass.readU2(fileInputStream)))
                            .toString());
        }

        s.append("\nclass accessFlag: ").append(accessFlag)
                .append("\nclass: ").append(klass)
                .append("\nsuper class: ").append(superKlass)
                .append("\ninterfaces: ").append(interfaceNameList.toString());

        Integer fieldCount = ParseClass.byteToShort(ParseClass.readU2(fileInputStream));
        s.append("\nfield: ");
        for (int i = 0; i < fieldCount; i++) {
            String fieldAccessFlag = ClassAndFieldAccessFlag
                    .getFlagName(ParseClass.readU2(fileInputStream));
            Integer nameIndex = ParseClass.byteToShort(ParseClass.readU2(fileInputStream));
            Integer descriptorIndex = ParseClass.byteToShort(ParseClass.readU2(fileInputStream));
            Integer attributeCount = ParseClass.byteToShort(ParseClass.readU2(fileInputStream));
            List<String> attributeList = new ArrayList<>();
            for (int j = 0; j < attributeCount; j++) {
                //TODO read attribute info
                Integer attributeIndex = ParseClass.byteToShort(ParseClass.readU2(fileInputStream));
                String attribute = constantMap.get(attributeIndex).toString();
                attributeList.add(attribute);
            }
            Field field = new Field(fieldAccessFlag, nameIndex, descriptorIndex, attributeCount,
                    constantMap, attributeList);
            s.append(field.toString()).append("\n");
        }

        Integer methodCount = ParseClass.byteToShort(ParseClass.readU2(fileInputStream));
        for (int i = 0; i < methodCount; i++) {
            String methodAccFlag = ClassAndFieldAccessFlag
                    .getMethodFlagName(ParseClass.readU2(fileInputStream));
            Integer nameIndex = ParseClass.byteToShort(ParseClass.readU2(fileInputStream));
            Integer descriptorIndex = ParseClass.byteToShort(ParseClass.readU2(fileInputStream));
            Integer attributeCount = ParseClass.byteToShort(ParseClass.readU2(fileInputStream));
            List<String> attributeList = new ArrayList<>();
            for (int j = 0; j < attributeCount; j++) {
                //read attribute info
                Integer attributeIndex = ParseClass.byteToShort(ParseClass.readU2(fileInputStream));
                String attribute = constantMap.get(attributeIndex).toString();
                Integer attrLength = ParseClass.byteToInt(ParseClass.readU4(fileInputStream));
                Integer maxStack = ParseClass.byteToShort(ParseClass.readU2(fileInputStream));
                Integer maxLocals = ParseClass.byteToShort(ParseClass.readU2(fileInputStream));
                Integer codeLength = ParseClass.byteToInt(ParseClass.readU4(fileInputStream));
                String code = "code index:";
                for (int k = 0; k < codeLength; k++) {
                    String byteCode = "0x" + DatatypeConverter
                            .printHexBinary(ParseClass.readU1(fileInputStream));
                    code += " " + byteCode;
                }
                Integer exceptionTableLength = ParseClass
                        .byteToShort(ParseClass.readU2(fileInputStream));
                for (int k = 0; k < exceptionTableLength; k++) {
                    //TODO read exceptions
                    Integer startPC = ParseClass.byteToShort(ParseClass.readU2(fileInputStream));
                    Integer endPC = ParseClass.byteToShort(ParseClass.readU2(fileInputStream));
                    Integer handlerPC = ParseClass.byteToShort(ParseClass.readU2(fileInputStream));
                    Integer catchTypeIndex = ParseClass
                            .byteToShort(ParseClass.readU2(fileInputStream));

                }
                Integer codeAttributeCount = ParseClass
                        .byteToShort(ParseClass.readU2(fileInputStream));
                for (int k = 0; k < codeAttributeCount; k++) {
                    //TODO read code attr
                    Integer codeAttributeIndex = ParseClass
                            .byteToShort(ParseClass.readU2(fileInputStream));
                    String codeAttribute = constantMap.get(codeAttributeIndex).toString();
                    Integer codeAttrLength = ParseClass
                            .byteToInt(ParseClass.readU4(fileInputStream));
                    String codeInfo = "";
                    for (int l = 0; l < codeAttrLength; l++) {
                        String codeAttrInfo = DatatypeConverter
                                .printHexBinary(ParseClass.readU1(fileInputStream));
                        codeInfo += " " + codeAttrInfo;
                    }
                    s.append("\n " + codeAttribute + codeInfo);
                }
                s.append("\n" + code);
                attributeList.add(attribute);
            }
            Field method = new Field(methodAccFlag, nameIndex, descriptorIndex, attributeCount,
                    constantMap, attributeList);
            s.append("\nmethods: " + method.toString()).append("\n");
        }

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
        return ((array[0] & 0xff) >> 4) + array[1] & 0xff;
    }

    public static int byteToInt(byte[] array) {
        assert array.length == 4;
        return ((array[0] & 0xff) >> 12) + ((array[1] & 0xff) >> 8) + ((array[2] & 0xff) >> 4) + array[3] & 0xff;
    }


}
