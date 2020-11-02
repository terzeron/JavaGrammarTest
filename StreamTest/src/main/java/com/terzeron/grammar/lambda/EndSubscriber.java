package com.terzeron.grammar.lambda;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public class EndSubscriber<T> implements Subscriber<T> {
    private Subscription subscription;
    public List<T> consumedElements = new LinkedList<>();

    @Override public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override public void onNext(T item) {
        System.out.println("Got : " + item);
        subscription.request(1);
    }

    @Override public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override public void onComplete() {
        System.out.println("Done");
    }
}

