package com.terzeron.grammar.processor;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.atomic.AtomicInteger;

public class EndSubscriber2<T> implements Subscriber<T> {
    private AtomicInteger howMuchMessagesConsume;
    private Subscription subscription;
    public List<T> consumedElements = new LinkedList<>();

    public EndSubscriber2(Integer howMuchMessagesConsume) {
        this.howMuchMessagesConsume = new AtomicInteger(howMuchMessagesConsume);
    }

    @Override public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override public void onNext(T item) {
        howMuchMessagesConsume.decrementAndGet();
        System.out.println("Got : " + item);
        consumedElements.add(item);
        // 생성 시에 설정된 최대치 이상 consume되면 publisher에 더 요청하지 않음
        if (howMuchMessagesConsume.get() > 0) {
            subscription.request(1);
        }
    }

    @Override public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override public void onComplete() {
        System.out.println("Done");
    }
}

