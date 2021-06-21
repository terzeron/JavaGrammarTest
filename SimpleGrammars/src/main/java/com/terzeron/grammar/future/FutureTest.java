package com.terzeron.grammar.future;

import java.time.LocalTime;
import java.util.concurrent.*;

public class FutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        log("now");

        testCompletableFuture();
        testCompletedFuture();
        testCancelledFuture();
    }

    static void testCompletableFuture() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = new CompletableFuture<>();
        Executors.newCachedThreadPool().submit(() -> {
            Thread.sleep(2000);
            future.complete("Finished");
            return null;
        });
        log(future.get());
    }

    static void testCompletedFuture() throws ExecutionException, InterruptedException {
        Future<String> future2 = CompletableFuture.completedFuture("Skip!");
        String result = future2.get();
        log(result);
    }

    static void testCancelledFuture() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = new CompletableFuture<>();
        Executors.newCachedThreadPool().submit(() -> {
            Thread.sleep(2000);
            future.cancel(false);
            return null;
        });

        String result = null;
        try {
            result = future.get();
        } catch (CancellationException e) {
            e.printStackTrace();
            result = "Canceled!";
        }
        log(result);
    }

    public static void log(String msg) {
        System.out.println(LocalTime.now() + ": " + Thread.currentThread().getName() + ": " + msg);
    }
}
