package net.terzeron.test.nio;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

/**
 * Created by terzeron on 2015-12-08.
 */
public class CopyTest {
    public static void main(String[] args) {
        Path source = Paths.get("test1");
        Path target = Paths.get("test2");
        try {
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.out.println("Exception while copying using new API");
        }
        System.out.println("File created: " + Files.exists(target));

        try {
            List<String> lineReadNew = Files.readAllLines(source, Charset.defaultCharset());
            System.out.println("Lines read using new style: ");
            for (String s : lineReadNew) {
                System.out.println(s);
            }
        } catch (IOException e) {
            System.out.println("error in reading a file");
        }
    }
}
