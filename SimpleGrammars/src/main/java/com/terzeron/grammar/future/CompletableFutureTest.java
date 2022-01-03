package com.terzeron.grammar.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CompletableFutureTest {
    // https://www.baeldung.com/java-completablefuture

    public static void main(String[] args) throws Exception {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
        test9();
        test10();
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
            // future를 체인으로 이을 때 thenApply를 사용
            // non void 타입의 future가 반환됨
            CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "java");
            CompletableFuture<String> future2 = future1.thenApply(s -> s + "coffee");
            System.out.println(future1.get());
            System.out.println(future2.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void test6() {
        System.out.println("---- test6 ----");
        try {
            // 이전 future의 결과가 필요한 경우 thenAccept를 사용
            // 결과가 준비되는 타아밍에 thenRun callback이 실행됨. 이는 get() 호출과 상관없음
            // void 타입의 future가 반환됨
            CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");
            CompletableFuture<Void> future2 = future1.thenAccept(s -> System.out.println("future1 finished: " + s));
            future2.thenRun(() -> System.out.println("future2 finished"));
            System.out.println(future1.get());
            System.out.println(future2.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void test7() {
        System.out.println("---- test7 ----");
        try {
            // 이전 future의 결과가 필요없을 때, thenRun을 사용
            // void 타입의 future가 반환됨
            CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");
            CompletableFuture<Void> future2 = future1.thenRun(() -> System.out.println("future1 finished."));
            future2.thenRun(() -> System.out.println("future2 finished"));
            System.out.println(future1.get());
            System.out.println(future2.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void test8() {
        System.out.println("---- test8 ----");
        try {
            // 모나딕 디자인 패턴: chaining, combining
            // chaining 기법으로 thenApply나 thenCompose를 이용해 빌딩블록을 조립할 수 있음
            // thenCompose의 차별점은 같은 타입의 객체를 반환하는 함수를 받는다는 것임
            // 반면에 thenApply는 future의 타입을 계속 변경할 수 있음
            CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello")
                    .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + " world"));
            System.out.println(future1.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void test9() {
        System.out.println("---- test9 ----");
        try {
            // combining 기법
            CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello")
                    .thenCombine(CompletableFuture.supplyAsync(() -> " world"), (s1, s2) -> s1 + s2);
            System.out.println(future1.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void test10() {
        System.out.println("---- test10 ----");
        try {
            // combining 기법
            CompletableFuture<Void> future1 = CompletableFuture.supplyAsync(() -> "Hello")
                    .thenAcceptBoth(CompletableFuture.supplyAsync(() -> " world"), (s1, s2) -> System.out.println(s1 + s2));
            System.out.println(future1.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Future<String> calculateAsyncWithCancellation() throws Exception {
        System.out.println("start of calculateAsyncWithCancellation()");
        Future<String> completableFuture = new CompletableFuture<>();
        Executors.newCachedThreadPool().submit(() -> {
            Thread.sleep(1000);
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
            Thread.sleep(1000);
            completableFuture.complete("hello");
            return null;
        });
        System.out.println("end of calculateAsync()");
        return completableFuture;
    }
}
