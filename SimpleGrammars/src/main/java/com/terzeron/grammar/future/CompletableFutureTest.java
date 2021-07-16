package com.terzeron.grammar.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CompletableFutureTest {
    public static void main(String[] args) throws Exception {
        test1();
        test2();
        test3();
        test4();
        test5();
    }

    public static void test1() {
        System.out.println("---- test1 ----");
        try {
            Future<String> completableFuture = calculateAsync();
            String result = completableFuture.get();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void test2() {
        System.out.println("---- test2 ----");
        try {
            Future<String> completableFuture = CompletableFuture.completedFuture("world");
            String result = completableFuture.get();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void test3() {
        System.out.println("---- test3 ----");
        try {
            Future<String> completableFuture = calculateAsyncWithCancellation();
            String result = completableFuture.get(); // CancellationException 발생
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void test4() {
        System.out.println("---- test4 ----");
        try {
            Future<String> completableFuture = CompletableFuture.supplyAsync(() -> "java");
            String result = completableFuture.get();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void test5() {
        System.out.println("---- test5 ----");
        try {
            CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "java");
            CompletableFuture<String> completableFuture2 = completableFuture.thenApply(s -> s + "coffee");
            String result = completableFuture.get();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Future<String> calculateAsyncWithCancellation() throws Exception {
        System.out.println("start of calculateAsyncWithCancellation()");
        Future<String> completableFuture = new CompletableFuture<>();
        Executors.newCachedThreadPool().submit(() -> {
            Thread.sleep(2000);
            completableFuture.cancel(false);
            return null;
        });
        System.out.println("end of calculateAsyncWithCancellation()");
        return completableFuture;
    }

    public static Future<String> calculateAsync() throws InterruptedException {
        System.out.println("start of calculateAsync()");
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        Executors.newCachedThreadPool().submit(() -> {
            Thread.sleep(2000);
            completableFuture.complete("hello");
            return null;
        });
        System.out.println("end of calculateAsync()");
        return completableFuture;
    }
}
