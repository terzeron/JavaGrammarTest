package net.terzeron.test.version;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class VersionCheck {

    public static void main(String[] args) throws IOException {
        System.out.println("version of bytecode: " + getVersionDetails("target/classes/net/terzeron/test/version/VersionCheck.class"));
    }

    public static String getVersionDetails(String filename) throws IOException {
        System.out.println("current working directory: " + new java.io.File(".").getCanonicalPath());
        String version = "";
        DataInputStream stream = new DataInputStream(new FileInputStream(filename));
        int magicBytes = stream.readInt();
        if (magicBytes != 0xcafebabe) {
            System.out.println(filename + " is not a valid java file!");
        } else {
            int minorVersion = stream.readUnsignedShort();
            int majorVersion = stream.readUnsignedShort();
            version = majorVersion + "." + minorVersion;
        }
        stream.close();
        return version;
    }
}
