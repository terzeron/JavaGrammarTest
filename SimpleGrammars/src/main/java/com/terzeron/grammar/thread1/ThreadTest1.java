package com.terzeron.grammar.thread1;

import java.lang.String;

public class ThreadTest1 extends Thread {
    int count = 0;
    String iam = "unknown";

    public ThreadTest1(String who) {
        System.out.println("...");
        iam = who;
    }

    public void run() {
        while (count < 20) {
            count++;
            System.out.println(iam + " " + count + " I'm a fool.");
            try {
                sleep((long) (java.lang.Math.random() * 3000));
            } catch (InterruptedException e) {
            }
        }

    }
}
