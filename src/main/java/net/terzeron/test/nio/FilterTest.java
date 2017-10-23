package net.terzeron.test.nio;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by terzeron on 2017. 5. 15..
 */
public class FilterTest {
    public static void main(String[] args) {
        Path basePath = Paths.get("/tmp");
        try (DirectoryStream<Path> pathList = Files.newDirectoryStream(basePath, "*.out")) {
            for (Path path : pathList) {
                System.out.println(path.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //
        // another way
        //

        DirectoryStream.Filter<Path> documentFilter = new DirectoryStream.Filter<Path>() {
            public boolean accept(Path entry) throws IOException {
                String fileName = entry.getFileName().toString();
                return fileName != null & fileName.endsWith("out");
            }
        };

        try (DirectoryStream<Path> pathList = Files.newDirectoryStream(basePath, documentFilter)) {
            for (Path path : pathList) {
                System.out.println(path);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
