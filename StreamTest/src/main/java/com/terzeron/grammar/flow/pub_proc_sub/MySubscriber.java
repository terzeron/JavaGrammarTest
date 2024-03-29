package com.terzeron.grammar.flow.pub_proc_sub;

import java.util.concurrent.Flow;

import static java.lang.Thread.currentThread;

public class MySubscriber implements Flow.Subscriber<String> {
    private static final String LOG_MESSAGE_FORMAT = "Subscriber >> [%s] %s%n";
    private long DEMAND = 0;
    private Flow.Subscription subscription;
    private long count;

    public void setDEMAND(long n) {
        this.DEMAND = n;
        count = DEMAND;
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        log("Subscribed");
        this.subscription = subscription;
    }

    @Override
    public void onNext(String item) {
        if (item != null) {
            log(item);
            synchronized (this) {
                count--;
                if (count == 0) {
                    log("Cancelling subscription...");
                    subscription.cancel();
                }
            }
        } else {
            log("Null item!");
        }
    }

    @Override
    public void onComplete() {
        log("onComplete(): There is no remaining item in Processor.");
    }

    @Override
    public void onError(Throwable t) {
        log("Error >> %s", t);
    }

    private void log(String message, Object... args) {
        String fullMessage = String.format(LOG_MESSAGE_FORMAT, currentThread().getName(), message);

        System.out.printf(fullMessage, args);
    }
}
