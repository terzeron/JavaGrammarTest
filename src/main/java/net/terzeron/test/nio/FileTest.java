package net.terzeron.test.nio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by terzeron on 2015-12-08.
 */
public class FileTest {
    public static void main(String[] args) {
        Path newFile = Paths.get("test1");
        try {
            Files.deleteIfExists(newFile);
            newFile = Files.createFile(newFile);
        } catch (IOException ex) {
            System.out.println("Error creating file");
        }
        System.out.println(Files.exists(newFile));

        try (BufferedWriter writer = Files.newBufferedWriter(newFile, Charset.defaultCharset())) {
            writer.append("This is first line");
            writer.newLine();
            writer.append("This is second line");
            writer.newLine();
        } catch (IOException ex) {
            System.out.println("error wrinting to file");
        }

        try (BufferedReader reader = Files.newBufferedReader(newFile, Charset.defaultCharset())) {
            String lineFromFile = "";
            System.out.println("The contents of file are: ");
            while ((lineFromFile = reader.readLine()) != null) {
                System.out.println(lineFromFile);
            }
        } catch (IOException ex) {
            System.out.println("Error while reading file");
        }
    }
}
