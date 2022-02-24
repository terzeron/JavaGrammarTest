package com.terzeron.grammar.reactor;

import java.util.Random;

public class BlockingWebClient {
    public BlockingWebClient() {

    }

    public String get(String url) {
        System.out.println(Thread.currentThread().getName() + " blocked at " + url);
        Random rand = new Random(System.currentTimeMillis());
        int r = rand.nextInt(100);
        try {
            Thread.sleep(200 + r);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return url;
    }
}
