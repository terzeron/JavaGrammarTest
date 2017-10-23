package net.terzeron.test.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * Created by terzeron on 2017. 5. 15..
 */
public class FileLockTest {
    public static void main(String[] args) throws Exception {
        RandomAccessFile file = null;
        FileLock fileLock = null;

        try {
            file = new RandomAccessFile("FileToBeLocked", "rw");
            FileChannel fileChannel = file.getChannel();

            fileLock = fileChannel.tryLock();
            if (fileLock != null) {
                System.out.println("File is locked");
                accessTheLockedFile();
            }
        } catch (FileNotFoundException e) {
            System.out.println("can't find the file");
        } catch (IOException e) {
            System.out.println("can't lock the file");
        } finally {
            if (fileLock != null) {
                System.out.println("file lock is to be released");
                fileLock.release();
            }
        }
    }

    static void accessTheLockedFile() {
        try {
            FileInputStream input = new FileInputStream("FileToBeLocked");
            int data = input.read();
            System.out.println(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
