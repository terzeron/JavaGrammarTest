package com.terzeron.grammar.nio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by terzeron on 2017. 5. 15..
 */
@Slf4j
public class ListFileTest {
    public static void main(String[] args) {
        Path basePath = Paths.get("/tmp");
        System.out.println("all files:");
        try (DirectoryStream<Path> pathList = Files.newDirectoryStream(basePath)) {
            for (Path path : pathList) {
                System.out.println(path.toString());
            }
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }
}
