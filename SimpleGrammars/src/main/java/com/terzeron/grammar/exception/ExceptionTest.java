package com.terzeron.grammar.exception;

import java.io.File;
import java.io.IOException;

/**
 *
 */

/**
 * @author terzeron
 */
public class ExceptionTest {
    public static void main(String[] args) {
        test();
    }

    private static void test() {
        String fileName = "terzeron3";
        String dir = "/Users/xxx/";
        File x = new File(dir, fileName);
        try {
            x.createNewFile();
        } catch (IOException e) {
            System.out.println("io com.terzeron.grammar.exception, " + e.getMessage() + ", " + e);
            throw new RuntimeException();

            //throw e;
        }
    }
}
