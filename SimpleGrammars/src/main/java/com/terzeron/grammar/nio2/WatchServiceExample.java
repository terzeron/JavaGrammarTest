package com.terzeron.grammar.nio2;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.WatchEvent.Kind;

import static java.nio.file.StandardWatchEventKinds.*;

public class WatchServiceExample {
    public static void main(String[] args) throws IOException, InterruptedException {
        WatchService watcher = FileSystems.getDefault().newWatchService();
        Path dir = FileSystems.getDefault().getPath("/usr/karianna");
        WatchKey key = dir.register(watcher, ENTRY_MODIFY, ENTRY_CREATE, ENTRY_DELETE);
        while (true) {
            key = watcher.take();
            for (WatchEvent<?> event : key.pollEvents()) {
                var kind = event.kind();
                if (kind.equals(StandardWatchEventKinds.ENTRY_CREATE)) {
                    System.out.println("CREATED");
                }
             }
            key.reset();
        }
    }
}
