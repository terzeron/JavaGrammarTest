package net.terzeron.test.file_system;

import java.io.File;

/**
 * Created by terzeron on 2016. 8. 23..
 */
public class CountFileTest {
    public static void main(String[] args) {
        int count = new File("../../../../../../../../..").list().length;
        System.out.println("Number of file: " + count);
    }
}
