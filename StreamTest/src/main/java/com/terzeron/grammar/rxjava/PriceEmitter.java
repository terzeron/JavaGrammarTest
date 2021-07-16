package com.terzeron.grammar.rxjava;

import rx.Observable;
import rx.AsyncEmitter;
import rx.observables.ConnectableObservable;

import static com.terzeron.grammar.rxjava.Utils.print;

public class PriceEmitter {
    public static void main(String[] args) {
        SomeFeed<PriceTick> feed = new SomeFeed();
        Observable<PriceTick> obs =
                Observable.fromEmitter((AsyncEmitter<PriceTick> emitter) -> {
                    SomeListener listener = new SomeListener() {
                        @Override
                        public void priceTick(PriceTick event) {
                            emitter.onNext(event);
                            if (event.isLast()) {
                                emitter.onCompleted();
                            }
                        }

                        @Override
                        public void error(Throwable e) {
                            emitter.onError(e);
                        }
                    };
                    feed.register(listener);
                }, AsyncEmitter.BackpressureMode.BUFFER); // consume될 때까지 버퍼링됨

        print("Sleep 5 seconds");
        try {
            Thread.sleep(5_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        obs.take(5).subscribe((priceTick) ->
                System.out.printf("1 %s %4s %6.2f%n", priceTick.getDate(),
                        priceTick.getInstrument(), priceTick.getPrice()));

        print("Sleep 5 seconds");
        try {
            Thread.sleep(5_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // cold observable을 hot observable로 변경
        ConnectableObservable<PriceTick> hotObservable = obs.publish();
        hotObservable.connect();

        hotObservable.take(5).subscribe((priceTick) ->
                System.out.printf("1 %s %4s %6.2f%n", priceTick.getDate(),
                        priceTick.getInstrument(), priceTick.getPrice()));

        print("Sleep 5 seconds");
        try {
            Thread.sleep(5_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        hotObservable.take(5).subscribe((priceTick) ->
                System.out.printf("2 %s %4s %6.2f%n", priceTick.getDate(),
                        priceTick.getInstrument(), priceTick.getPrice()));
    }
}
