package com.terzeron.grammar.rxjava;

import rx.Observable;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Metronome {
    private static boolean isSlowTickTime() {
        return LocalDate.now().getDayOfWeek() == DayOfWeek.SATURDAY ||
                LocalDate.now().getDayOfWeek() == DayOfWeek.SUNDAY;
    }

    private static long start = System.currentTimeMillis();

    private static boolean isSlowTime() {
        return (System.currentTimeMillis() - start) % 30_000 >= 15_000;
    }

    public static void main(String[] args) {
        Observable<Long> fast = Observable.interval(1, TimeUnit.SECONDS);
        Observable<Long> slow = Observable.interval(3, TimeUnit.SECONDS);

        Observable<Long> clock = Observable.merge(slow.filter(tick -> isSlowTime()),
                fast.filter(tick -> !isSlowTime()));
        clock.subscribe(tick -> System.out.println(new Date()));

        try {
            Thread.sleep(60_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
