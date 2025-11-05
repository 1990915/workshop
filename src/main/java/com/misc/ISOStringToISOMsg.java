package com.misc;

import org.jpos.iso.ISOMsg;
import org.jpos.iso.packager.GenericPackager;

import java.io.File;

public class ISOStringToISOMsg {
    public static void main(String[] args) throws Exception {
        // Load the packager definition
        //File file=new File("config/basic.xml");
        GenericPackager packager = new GenericPackager("basic.xml");
        // Example packed ISO message (ASCII)
        String isoString = "0200322000000000000000000000100001103221800123456123456789012TERMID01840";
        // Convert string to byte[]
        byte[] data = isoString.getBytes();

        // Create ISOMsg and unpack
        ISOMsg isoMsg = new ISOMsg();
        isoMsg.setPackager(packager);
        isoMsg.unpack(data);

        // Display fields
        logISOMsg(isoMsg);
    }

    private static void logISOMsg(ISOMsg msg) {
        System.out.println("---- ISO MESSAGE ----");
        try {
            System.out.println("MTI : " + msg.getMTI());
            for (int i = 1; i <= msg.getMaxField(); i++) {
                if (msg.hasField(i)) {
                    System.out.println("Field " + i + " : " + msg.getString(i));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
