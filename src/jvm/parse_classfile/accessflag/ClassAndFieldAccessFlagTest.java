package jvm.parse_classfile.accessflag;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.xml.bind.DatatypeConverter;
import jvm.parse_classfile.U2;
import jvm.parse_classfile.U4;
import org.junit.Test;

public class ClassAndFieldAccessFlagTest {

    @Test
    public void getFlagName() {
        assertEquals("public super", ClassAndFieldAccessFlag.getFlagName(new byte[]{ 0x00, 0x21 }));

        assertEquals("public", ClassAndFieldAccessFlag.getFlagName(new byte[]{0x00, 0x01}));
        assertEquals("final", ClassAndFieldAccessFlag.getFlagName(new byte[]{0x00, 0x10}));
        assertEquals("super", ClassAndFieldAccessFlag.getFlagName(new byte[]{0x00, 0x20}));
        assertEquals("private", ClassAndFieldAccessFlag.getFlagName(new byte[]{0x00, 0x02}));
        assertEquals("protected", ClassAndFieldAccessFlag.getFlagName(new byte[]{0x00, 0x04}));
        assertEquals("static", ClassAndFieldAccessFlag.getFlagName(new byte[]{0x00, 0x08}));
        assertEquals("volatile", ClassAndFieldAccessFlag.getFlagName(new byte[]{0x00, 0x40}));
        assertEquals("transient", ClassAndFieldAccessFlag.getFlagName(new byte[]{0x00, -0x80}));
        assertEquals("interface", ClassAndFieldAccessFlag.getFlagName(new byte[]{0x02, 0x00}));
        assertEquals("abstract", ClassAndFieldAccessFlag.getFlagName(new byte[]{0x04, 0x00}));
        assertEquals("synthetic", ClassAndFieldAccessFlag.getFlagName(new byte[]{0x10, 0x00}));
        assertEquals("annotation", ClassAndFieldAccessFlag.getFlagName(new byte[]{0x20, 0x00}));
        assertEquals("enum", ClassAndFieldAccessFlag.getFlagName(new byte[]{0x40, 0x00}));

//        assertEquals(80,DatatypeConverter.printHexBinary(new byte[]{-128}));

    }
}
