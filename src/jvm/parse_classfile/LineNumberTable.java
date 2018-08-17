package jvm.parse_classfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LineNumberTable extends Attribute {

    private FileInputStream fileInputStream;
    private FileOutputStream fileOutputStream;
    private int lineNumberTableLength;

    private List<LineNumberInfo> lineNumberInfoList = new ArrayList<>();
    private HashMap constantPoolMap;

    public LineNumberTable() {
    }

    public LineNumberTable(HashMap constantPoolMap) {
        this.constantPoolMap = constantPoolMap;
    }

    public void read(FileInputStream fileInputStream) {
//        try {
//            fileOutputStream = new FileOutputStream("src/jvm/parse_classfile/LineNumber.txt");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
        attrNameIndex = U2.read(fileInputStream);
        attrLength = U4.read(fileInputStream);
        lineNumberTableLength = U2.read(fileInputStream);
        for (int i = 0; i < lineNumberTableLength; i++) {
            LineNumberInfo lineNumberInfo = new LineNumberInfo();
            lineNumberInfo.read(fileInputStream);
            lineNumberInfoList.add(lineNumberInfo);
        }
    }

    public int getLineNumberTableLength() {
        return lineNumberTableLength;
    }

    public List<LineNumberInfo> getLineNumberInfoList() {
        return lineNumberInfoList;
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
            return "startPC: " + startPC + " lineNumber: " + lineNumber ;
        }
    }
}
