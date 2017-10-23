package net.terzeron.test.compress;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.Deflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by terzeron on 2016. 8. 23..
 */
public class ZipTest {
    public static void main(String[] args) throws IOException {
        List<File> files = new ArrayList<File>();
        files.add(new File("textfile.txt"));
        ZipTest.packageZipFile(new File("testzip.zip"), files);
    }

    public static void packageZipFile(File output, List<File> files) throws IOException {
        System.out.println("Packaging to " + output.getName());

        // zip outpstream 생성
        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(output));
        zipOutputStream.setLevel(Deflater.DEFAULT_COMPRESSION);

        for (File file : files) {
            if (file.isDirectory()) {
                zipDirectory(zipOutputStream, "", file);
            } else {
                zipFile(zipOutputStream, "", file);
            }
        }
        zipOutputStream.flush();
        zipOutputStream.close();
        System.out.println("Zipping done");
    }

    private static String buildPath(String filePath, String fileVar) {
        if (filePath == null || filePath.isEmpty()) {
            return fileVar;
        } else {
            return filePath + "/" + fileVar;
        }
    }

    private static void zipDirectory(ZipOutputStream zipOutputStream, String filePath, File directory) throws IOException {
        if (!directory.canRead()) {
            System.out.println("cannot read " + directory.getCanonicalPath() + " (maybe because of permissions)");
            return;
        }

        File[] files = directory.listFiles();
        filePath = buildPath(filePath, directory.getName());
        System.out.println("Adding directory " + filePath);

        for (File source : files) {
            if (source.isDirectory()) {
                zipDirectory(zipOutputStream, filePath, source);
            } else {
                zipFile(zipOutputStream, filePath, source);
            }
        }
        System.out.println("Leaving directory " + filePath);
    }

    private static void zipFile(ZipOutputStream zipOutputStream, String filePath, File file) throws IOException {
        if (!file.canRead()) {
            System.out.println("Cannot read file: " + file.getCanonicalPath());
            return;
        }
        System.out.println("Compressing file: " + file.getName());
        zipOutputStream.putNextEntry(new ZipEntry(buildPath(filePath, file.getName())));
        FileInputStream fileInputStream = new FileInputStream(file);

        byte[] bufferVar = new byte[4096];
        int byteVar = 0;
        while ((byteVar = fileInputStream.read(bufferVar)) != -1) {
            zipOutputStream.write(bufferVar, 0, byteVar);
            System.out.println(".");
            System.out.flush();
        }
        fileInputStream.close();
        zipOutputStream.closeEntry();
    }
}
