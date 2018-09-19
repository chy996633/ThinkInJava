package jvm.parse_classfile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CodeAttribute extends Attribute {

    private FileInputStream fileInputStream;
    private FileOutputStream fileOutputStream;
    private List<Attribute> attributes = new ArrayList<>();


    private HashMap constantPoolMap;


    public CodeAttribute(HashMap constantPoolMap, int attrNameIndex, int attrLength) {
        super(attrNameIndex, attrLength);
        this.constantPoolMap = constantPoolMap;
    }

    public CodeAttribute(int attrNameIndex, int attrLength) {
        super(attrNameIndex, attrLength);
    }

    public void read(FileInputStream fileInputStream) {

        String attrName = constantPoolMap.get(attrNameIndex).toString();
        switch (attrName) {
            case "LineNumberTable":
                LineNumberTable lineNumberTable = new LineNumberTable(attrNameIndex, attrLength);
                lineNumberTable.read(fileInputStream);
                attributes.add(lineNumberTable);
                break;
            case "LocalVariableTable":
                LocalVariableTable localVariableTable = new LocalVariableTable(attrNameIndex,
                        attrLength);
                localVariableTable.read(fileInputStream);
                attributes.add(localVariableTable);
                break;
            case "StackMapTable":
                StackMapTable stackMapTable = new StackMapTable(attrNameIndex, attrLength);
                stackMapTable.read(fileInputStream);
                attributes.add(stackMapTable);
                break;
            default:
                System.out.println("unfound attr in Code: "+ attrName);
        }
    }

    @Override
    public String toString() {
        StringBuffer s = new StringBuffer();
        attributes.forEach(attribute -> s.append(attribute.toString()));
        return s.toString();
    }

    public class LineNumberTable extends Attribute {

        private List<LineNumberInfo> lineNumberInfoList = new ArrayList<>();
        private int lineNumberTableLength;

        public LineNumberTable(int attrNameIndex, int attrLength) {
            super(attrNameIndex, attrLength);
        }

        public void read(FileInputStream fileInputStream) {
            lineNumberTableLength = U2.read(fileInputStream);
            for (int i = 0; i < lineNumberTableLength; i++) {
                LineNumberInfo lineNumberInfo = new LineNumberInfo();
                lineNumberInfo.read(fileInputStream);
                lineNumberInfoList.add(lineNumberInfo);
            }

        }

        public List<LineNumberInfo> getLineNumberInfoList() {
            return lineNumberInfoList;
        }

        public int getLineNumberTableLength() {
            return lineNumberTableLength;
        }

        @Override
        public String toString() {
            String result = constantPoolMap.get(attrNameIndex).toString() + " ";
            for (LineNumberInfo info : lineNumberInfoList) {
                result += info.toString() + " ";
            }
            return result;
        }

        class LineNumberInfo {

            private int startPC;

            private int lineNumber;

            public void read(FileInputStream fileInputStream) {
                this.startPC = U2.read(fileInputStream);
                this.lineNumber = U2.read(fileInputStream);
            }

            public int getStartPC() {
                return startPC;
            }

            public int getLineNumber() {
                return lineNumber;
            }

            @Override
            public String toString() {
                return "startPC: " + startPC + " lineNumber: " + lineNumber;
            }
        }

    }


    public class LocalVariableTable extends Attribute {

        private int localVariableInfoLength;

        private List<LocalVariableInfo> localVariableInfoList;

        public LocalVariableTable(int attrNameIndex, int attrLength) {
            super(attrNameIndex, attrLength);
        }


        @Override
        public void read(FileInputStream fileInputStream) {
            localVariableInfoLength = U2.read(fileInputStream);
            for (int i = 0; i < localVariableInfoLength; i++) {
                LocalVariableInfo localVariableInfo = new LocalVariableInfo();
                localVariableInfo.read(fileInputStream);
            }
        }


        class LocalVariableInfo {

            private int startPC;

            private int length;

            private int nameIndex;

            private int descriptorIndex;

            private int index;

            public void read(FileInputStream fileInputStream) {
                this.startPC = U2.read(fileInputStream);
                this.length = U2.read(fileInputStream);
                this.nameIndex = U2.read(fileInputStream);
                this.descriptorIndex = U2.read(fileInputStream);
                this.index = U2.read(fileInputStream);
            }

            @Override
            public String toString() {
                return "startPC: " + startPC + " length: " + length + " name: " + constantPoolMap
                        .get(nameIndex).toString() + " descriptor: " + constantPoolMap
                        .get(descriptorIndex).toString();
            }
        }

    }

    public class StackMapTable extends Attribute {

        private int stackMapEntryLength;

        public StackMapTable(int attrNameIndex, int attrLength) {
            super(attrNameIndex, attrLength);
        }

        @Override
        public void read(FileInputStream fileInputStream) {
            stackMapEntryLength = U2.read(fileInputStream);
        }
    }

}
