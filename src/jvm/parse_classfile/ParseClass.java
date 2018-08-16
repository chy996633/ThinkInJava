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

    public String parseClassFile() throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(
                "/home/backstop-samuel/git_code/ThinkInJava/src/bytecode/TestClass.class");
//                "/home/backstop-samuel/git_code/ThinkInJava/bin/jvm/parse_classfile/ClassAndFieldAccessFlag.class");
        StringBuilder s = new StringBuilder();
        s.append("magic: ")
                .append(U4.readString(fileInputStream))
                .append("\nminor_version: ")
                .append(U2.read(fileInputStream))
                .append("\nmajor_version: ")
                .append(U2.read(fileInputStream));

        Integer constantPoolCount = U2.read(fileInputStream) - 1;
        s.append("\nconstant_pool_count: ").append(constantPoolCount);

        HashMap<Integer, Constant> constantMap = new HashMap<>();
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

        String accessFlag = ClassAndFieldAccessFlag.getFlagName(U2.readU2(fileInputStream));
        String klass = constantMap.get(U2.read(fileInputStream))
                .toString();
        String superKlass = constantMap
                .get(U2.read(fileInputStream)).toString();
        Integer interfaceCount = U2.read(fileInputStream);
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

        Integer fieldCount = U2.read(fileInputStream);
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
            s.append(field.toString()).append("\n");
        }

        Integer methodCount = U2.read(fileInputStream);
        for (int i = 0; i < methodCount; i++) {
            String methodAccFlag = ClassAndFieldAccessFlag
                    .getMethodFlagName(U2.readU2(fileInputStream));
            Integer nameIndex = U2.read(fileInputStream);
            Integer descriptorIndex = U2.read(fileInputStream);
            Integer attributeCount = U2.read(fileInputStream);
            List<String> attributeList = new ArrayList<>();
            for (int j = 0; j < attributeCount; j++) {
                //read attribute info
                Integer attributeIndex = U2.read(fileInputStream);
                String attribute = constantMap.get(attributeIndex).toString();
                Integer attrLength = U4.read(fileInputStream);
                Integer maxStack = U2.read(fileInputStream);
                Integer maxLocals = U2.read(fileInputStream);
                Integer codeLength = U4.read(fileInputStream);
                String code = "code index:";
                for (int k = 0; k < codeLength; k++) {
                    String byteCode = "0x" + DatatypeConverter
                            .printHexBinary(U1.read(fileInputStream));
                    code += " " + byteCode;
                }
                Integer exceptionTableLength = U2.read(fileInputStream);
                for (int k = 0; k < exceptionTableLength; k++) {
                    //TODO read exceptions
                    Integer startPC = U2.read(fileInputStream);
                    Integer endPC = U2.read(fileInputStream);
                    Integer handlerPC = U2.read(fileInputStream);
                    Integer catchTypeIndex = U2.read(fileInputStream);

                }
                Integer codeAttributeCount = U2.read(fileInputStream);
                for (int k = 0; k < codeAttributeCount; k++) {
                    //TODO read code attr
                    Integer codeAttributeIndex = U2.read(fileInputStream);
                    String codeAttribute = constantMap.get(codeAttributeIndex).toString();
                    Integer codeAttrLength = U4.read(fileInputStream);
                    String codeInfo = "";
                    for (int l = 0; l < codeAttrLength; l++) {
                        String codeAttrInfo = DatatypeConverter
                                .printHexBinary(U1.read(fileInputStream));
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
        return s.toString();
    }

    public static void main(String[] args) throws IOException {
        ParseClass parseClass = new ParseClass();
        parseClass.parseClassFile();

    }

}
