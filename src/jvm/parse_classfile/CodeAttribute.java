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
                System.out.println("unfound attr in Code: " + attrName);
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
            for (int i = 0; i < stackMapEntryLength; i++) {
                int frameType = U1.readInt(fileInputStream);
                StackMapFrame stackMapFrame = null;
                if (frameType <= 63 && frameType >= 0) {
                    stackMapFrame = new SameFrame(frameType);
                } else if (frameType <= 127) {
                    stackMapFrame = new SameLocals1StackItemFrame(frameType);
                } else if (frameType == 247) {
                    stackMapFrame = new SameLocals1StackItemFrameExtended(frameType);
                } else if (frameType >= 248 && frameType <= 250) {
                    stackMapFrame = new ChopFrame(frameType);
                } else if (frameType == 251) {
                    stackMapFrame = new SameFrameExtended(frameType);
                } else if (frameType == 255) {
                    stackMapFrame = new FullFrame(frameType);
                } else {
                    System.out.println("unknown frameType: "+ frameType);
                }
                stackMapFrame.read(fileInputStream);
            }
        }

        abstract class StackMapFrame {

            int frameType;

            public StackMapFrame(int frameType) {
                this.frameType = frameType;
            }

            abstract void read(FileInputStream fileInputStream);
        }

        class SameFrame extends StackMapFrame {

            public SameFrame(int frameType) {
                super(frameType);
            }

            @Override
            void read(FileInputStream fileInputStream) {

            }
        }

        class SameLocals1StackItemFrame extends StackMapFrame {

            public SameLocals1StackItemFrame(int frameType) {
                super(frameType);
            }

            @Override
            void read(FileInputStream fileInputStream) {
                readVerificationTypeInfo(fileInputStream);
            }
        }

        class SameLocals1StackItemFrameExtended extends StackMapFrame {
            private int offSet;

            public SameLocals1StackItemFrameExtended(int frameType) {
                super(frameType);
            }

            @Override
            void read(FileInputStream fileInputStream) {
                offSet = U2.read(fileInputStream);
                readVerificationTypeInfo(fileInputStream);
            }
        }

        class SameFrameExtended extends StackMapFrame {
            private int offSet;

            public SameFrameExtended(int frameType) {
                super(frameType);
            }

            @Override
            void read(FileInputStream fileInputStream) {
                offSet = U2.read(fileInputStream);
            }
        }

        class ChopFrame extends StackMapFrame {
            private int offSet;

            public ChopFrame(int frameType) {
                super(frameType);
            }

            @Override
            void read(FileInputStream fileInputStream) {
                offSet = U2.read(fileInputStream);
            }
        }

        class FullFrame extends StackMapFrame {

            private int offSet;
            private int numberOfLocals;
            private int numberOfStack;

            public FullFrame(int frameType) {
                super(frameType);
            }

            @Override
            void read(FileInputStream fileInputStream) {
                offSet = U2.read(fileInputStream);
                numberOfLocals = U2.read(fileInputStream);
                for (int j = 0; j < numberOfLocals; j++) {
                    readVerificationTypeInfo(fileInputStream);
                }
                numberOfStack = U2.read(fileInputStream);
                for (int j = 0; j < numberOfStack; j++) {
                    readVerificationTypeInfo(fileInputStream);
                }
            }
        }


        public void readVerificationTypeInfo(FileInputStream fileInputStream) {
            int tag = U1.readInt(fileInputStream);
            if (tag == 7) {
                int index = U2.read(fileInputStream);
                ObjectVariableInfo ovi = new ObjectVariableInfo(tag, index);
            } else if (tag == 8) {
                int tagOffSet = U2.read(fileInputStream);
            }
        }

        abstract class VerificationTypeInfo {

            public VerificationTypeInfo(int tag) {
                this.tag = tag;
            }

            int tag;
        }

        class ObjectVariableInfo extends VerificationTypeInfo {

            int constantPoolIndex;

            public ObjectVariableInfo(int tag, int constantPoolIndex) {
                super(tag);
                this.constantPoolIndex = constantPoolIndex;
            }

        }

        //TODO other type info


    }


}
