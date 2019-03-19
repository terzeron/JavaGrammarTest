package com.terzeron.test.flow1;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        MyPublisher publisher = new MyPublisher();
        MySubscriber subscriberA = new MySubscriber("A");
        MySubscriber subscriberB = new MySubscriber("B");

        publisher.subscribe(subscriberA);
        publisher.subscribe(subscriberB);

        publisher.waitUntilTerminated();
    }
}