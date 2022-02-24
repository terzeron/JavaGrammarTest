package com.terzeron.grammar.reactor;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.Arrays;
import java.util.List;


// https://spring.io/blog/2019/12/13/flight-of-the-flux-3-hopping-threads-and-schedulers
public class SchedulerTest1 {
    private BlockingWebClient blockingWebClient;
    private List<String> firstListOfUrls;
    private List<String> secondListOfUrls;

    public SchedulerTest1(BlockingWebClient blockingWebClient, List<String> firstListOfUrls, List<String> secondListOfUrls) {
        this.blockingWebClient = blockingWebClient;
        this.firstListOfUrls = firstListOfUrls;
        this.secondListOfUrls = secondListOfUrls;
    }

    public static void main(String[] args) throws InterruptedException {
        List<String> firstListOfUrls = Arrays.asList("A", "B", "C");
        List<String> secondListOfUrls = Arrays.asList("G", "H", "I");
        BlockingWebClient blockingWebClient = new BlockingWebClient();

        SchedulerTest1 schedulerTest = new SchedulerTest1(blockingWebClient, firstListOfUrls, secondListOfUrls);

        //schedulerTest.test1();
        //Thread.sleep(2000);

        //schedulerTest.test2();
        //Thread.sleep(2000);

        schedulerTest.test3();
        Thread.sleep(2000);
    }

    private void test1() {
        System.out.println("------ test1 ------");
        Flux.fromIterable(firstListOfUrls)
                .map(url -> blockingWebClient.get(url))
                .subscribe(body -> System.out.println(Thread.currentThread().getName() + " got " + body));

        // 첫번째 flux가 두번째 flux를 block함

        Flux.fromIterable(secondListOfUrls)
                .map(url -> blockingWebClient.get(url))
                .subscribe(body -> System.out.println(Thread.currentThread().getName() + " got " + body));
    }

    private void test2() {
        System.out.println("------ test2 ------");
        Flux.fromIterable(firstListOfUrls)
                .map(url -> {
                    System.out.println(Thread.currentThread().getName() + " made " + url);
                    return url;
                })
                .map(url -> {
                    System.out.println(Thread.currentThread().getName() + " passed " + url);
                    return url;
                })
                .publishOn(Schedulers.newParallel("scheduler-a", 10))
                .map(url -> blockingWebClient.get(url))
                .subscribe(body -> System.out.println(Thread.currentThread().getName() + " got " + body));

        // publishOn()에 의해 뒷쪽 subscriber가 별도의 쓰레드에서 처리됨
        // main ---+--+---------------------------------------- : publish
        //          \------ scheduler-a-1: subscribe first list
        //             \--- scheduler-b-2: subscribe second list
        // ex)
        // main made A
        // main passed A
        // scheduler-a-1 blocked at A
        // scheduler-a-1 got A

        Flux.fromIterable(secondListOfUrls)
                .map(url -> {
                    System.out.println(Thread.currentThread().getName() + " made " + url);
                    return url;
                })
                .map(url -> {
                    System.out.println(Thread.currentThread().getName() + " passed " + url);
                    return url;
                })
                .publishOn(Schedulers.newParallel("scheduler-b", 10))
                .map(url -> blockingWebClient.get(url))
                .subscribe(body -> System.out.println(Thread.currentThread().getName() + " got " + body));
    }

    final Flux<String> fetchUrls(List<String> urls) {
        return Flux.fromIterable(urls)
                .map(url -> blockingWebClient.get(url));
    }

    private void test3() {
        System.out.println("------ test3 ------");
        fetchUrls(Arrays.asList("A", "B", "C"))
                .map(url -> {
                    System.out.println(Thread.currentThread().getName() + " made " + url);
                    return url;
                })
                .map(url -> {
                    System.out.println(Thread.currentThread().getName() + " passed " + url);
                    return url;
                })
                .subscribeOn(Schedulers.newParallel("scheduler-c", 10))
                .subscribe(body -> System.out.println(Thread.currentThread().getName() + " got " + body));

        // subscribeOn()에 의해 쓰레드가 분리되어 뒷쪽 subscriber가 별도의 쓰레드에서 처리됨
        // 앞쪽 publisher는 subscriber와 같은 쓰레드에서 처리됨
        // main ---+--+------------------------------------------- : NO publish
        //          \--------- scheduler-c-1: publish & subscribe first list
        //             \------ scheduler-d-2: publish & subscribe second list
        // ex)
        // scheduler-c-1 blocked at A
        // scheduler-c-1 made A
        // scheduler-c-1 passed A
        // scheduler-c-1 got A

        fetchUrls(Arrays.asList("F", "G", "H"))
                .map(url -> {
                    System.out.println(Thread.currentThread().getName() + " made " + url);
                    return url;
                })
                .map(url -> {
                    System.out.println(Thread.currentThread().getName() + " passed " + url);
                    return url;
                })
                .subscribeOn(Schedulers.newParallel("scheduler-d", 10))
                .subscribe(body -> System.out.println(Thread.currentThread().getName() + " got " + body));
    }
}
