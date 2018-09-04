package net.terzeron.test.nio;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ReadFileToList {
    public static void main(String[] args) {
        Path sourcePath = Paths.get("testfile.txt");
        try {
            List<String> linesReadNew = Files.readAllLines(sourcePath, Charset.defaultCharset());
            System.out.println("Lines read using new style: ");
            for (String s : linesReadNew) {
                System.out.println(s);
            }
        } catch (IOException e) {
            System.out.println("IO Error");
        }
    }
}
