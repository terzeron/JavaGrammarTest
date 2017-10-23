package net.terzeron.test.async_file;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by terzeron on 2017. 9. 13..
 */
public class AsyncFutureRead {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(100);
        Path path = Paths.get("JavaGrammarTest/testfile.txt");

        try (AsynchronousFileChannel asyncChannel = AsynchronousFileChannel.open(path)) {
            Future<Integer> fileResult = asyncChannel.read(buffer, 0);

            while (!fileResult.isDone()) {
                System.out.println("Waiting to complete the file reading...");
            }

            System.out.println("Number of bytes read: " + fileResult.get());

            // Reset the current position of the buffer to the beginning and the limit to the current position.
            buffer.flip();

            System.out.println("Contents of file: ");
            System.out.println(Charset.defaultCharset().decode(buffer));
        } catch (IOException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
