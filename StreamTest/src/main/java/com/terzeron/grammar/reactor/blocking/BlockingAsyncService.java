package com.terzeron.grammar.reactor.blocking;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class BlockingAsyncService {
    private final BlockingService blockingService;

    public BlockingAsyncService(BlockingService blockingService) {
        this.blockingService = blockingService;
    }

    public Mono<String> get(String url) {
        return Mono.fromCallable(() -> blockingService.get(url))
                .subscribeOn(Schedulers.boundedElastic());
        // subscribeOn()을 호출함으로써
        // blocking 서비스를 호출하는 chain과 그 Mono stream을 받아서 처리하는 chain을
        // 묶어서 별도의 스케쥴러(쓰레드)로 분리하게 됨
    }
}
