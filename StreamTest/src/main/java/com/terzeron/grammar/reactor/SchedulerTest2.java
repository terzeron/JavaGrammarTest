package com.terzeron.grammar.reactor;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.util.Arrays;

// https://www.woolha.com/tutorials/project-reactor-publishon-vs-subscribeon-difference
public class SchedulerTest2 {
    private Scheduler schedulerA;
    private Scheduler schedulerB;

    public SchedulerTest2(Scheduler schedulerA, Scheduler schedulerB) {
        this.schedulerA = schedulerA;
        this.schedulerB = schedulerB;
    }

    public static void main(String[] args) {
        Scheduler schedulerA = Schedulers.newParallel("scheduler-a", 10);
        Scheduler schedulerB = Schedulers.newParallel("scheduler-b", 10);
        SchedulerTest2 schedulerTest2 = new SchedulerTest2(schedulerA, schedulerB);

        //schedulerTest2.noSchedulerTest();
        //schedulerTest2.publishOnTest1();
        //schedulerTest2.publishOnTest2();
        //schedulerTest2.subscribeOnTest1();
        //schedulerTest2.subscribeOnTest2();
        //schedulerTest2.mixTest1();
        //schedulerTest2.mixTest2();
        //schedulerTest2.nestedTest1();
        //schedulerTest2.nestedTest2();
        //schedulerTest2.nestedTest3();
        schedulerTest2.nestedTest4();
    }

    private void noSchedulerTest() {
        System.out.println("------ noSchedulerTest ------");
        Flux.range(1, 3)
                .map(i -> {
                    System.out.println("1st map(): " + Thread.currentThread().getName() + " " + i);
                    return i;
                })
                .map(i -> {
                    System.out.println("2nd map(): " + Thread.currentThread().getName() + " " + i);
                    return i;
                })
                .subscribe(i -> {
                    System.out.println("subscribe():" + Thread.currentThread().getName() + " " + i);
                });
    }

    private void publishOnTest1() {
        System.out.println("------ publishOnTest1 ------");
        Flux.range(1, 3)
                .map(i -> {
                    System.out.println("1st map(): " + Thread.currentThread().getName() + " " + i);
                    return i;
                })
                .publishOn(schedulerA)
                .map(i -> {
                    System.out.println("2nd map(): " + Thread.currentThread().getName() + " " + i);
                    return i;
                })
                .subscribe(i -> {
                    System.out.println("subscribe():" + Thread.currentThread().getName() + " " + i);
                });
    }

    private void publishOnTest2() {
        System.out.println("------ publishOnTest2 ------");
        Flux.range(1, 3)
                .map(i -> {
                    System.out.println("1st map(): " + Thread.currentThread().getName() + " " + i);
                    return i;
                })
                .publishOn(schedulerA)
                .map(i -> {
                    System.out.println("2nd map(): " + Thread.currentThread().getName() + " " + i);
                    return i;
                })
                .publishOn(schedulerB)
                .map(i -> {
                    System.out.println("3rd map(): " + Thread.currentThread().getName() + " " + i);
                    return i;
                })
                .subscribe(i -> {
                    System.out.println("subscribe():" + Thread.currentThread().getName() + " " + i);
                });
    }

    private void subscribeOnTest1() {
        System.out.println("------ subscribeOnTest1 ------");
        Flux.range(1, 3)
                .map(i -> {
                    System.out.println("1st map(): " + Thread.currentThread().getName() + " " + i);
                    return i;
                })
                .subscribeOn(schedulerA)
                .map(i -> {
                    System.out.println("2nd map(): " + Thread.currentThread().getName() + " " + i);
                    return i;
                })
                .subscribe(i -> {
                    System.out.println("subscribe():" + Thread.currentThread().getName() + " " + i);
                });
    }

    private void subscribeOnTest2() {
        System.out.println("------ subscribeOnTest2 ------");
        Flux.range(1, 3)
                .map(i -> {
                    System.out.println("1st map(): " + Thread.currentThread().getName() + " " + i);
                    return i;
                })
                .subscribeOn(schedulerA)
                .map(i -> {
                    System.out.println("2nd map(): " + Thread.currentThread().getName() + " " + i);
                    return i;
                })
                .subscribeOn(schedulerB)
                .map(i -> {
                    System.out.println("3rd map(): " + Thread.currentThread().getName() + " " + i);
                    return i;
                })
                .subscribe(i -> {
                    System.out.println("subscribe():" + Thread.currentThread().getName() + " " + i);
                });
    }

    private void mixTest1() {
        System.out.println("------ mixTest1 ------");
        Flux.range(1, 3)
                .map(i -> {
                    System.out.println("1st map(): " + Thread.currentThread().getName() + " " + i);
                    return i;
                })
                .publishOn(schedulerA)
                .map(i -> {
                    System.out.println("2nd map(): " + Thread.currentThread().getName() + " " + i);
                    return i;
                })
                .subscribeOn(schedulerB)
                .map(i -> {
                    System.out.println("3rd map(): " + Thread.currentThread().getName() + " " + i);
                    return i;
                })
                .subscribe(i -> {
                    System.out.println("subscribe():" + Thread.currentThread().getName() + " " + i);
                });
    }

    private void mixTest2() {
        System.out.println("------ mixTest2 ------");
        Flux.range(1, 3)
                .map(i -> {
                    System.out.println("1st map(): " + Thread.currentThread().getName() + " " + i);
                    return i;
                })
                .subscribeOn(schedulerA)
                .map(i -> {
                    System.out.println("2nd map(): " + Thread.currentThread().getName() + " " + i);
                    return i;
                })
                .publishOn(schedulerB)
                .map(i -> {
                    System.out.println("3rd map(): " + Thread.currentThread().getName() + " " + i);
                    return i;
                })
                .subscribe(i -> {
                    System.out.println("subscribe():" + Thread.currentThread().getName() + " " + i);
                });
    }

    private void nestedTest1() {
        System.out.println("------ nestedTest1 ------");
        Flux.range(1, 3)
                .map(i -> {
                    System.out.println("1st map():" + Thread.currentThread().getName() + " " + i);
                    return i;
                })
                .publishOn(schedulerA)
                .map(i -> {
                    System.out.println("2nd map():" + Thread.currentThread().getName() + " " + i);
                    return Flux.fromIterable(Arrays.asList("A", "B"))
                            .map(j -> {
                                System.out.println("nested 1st map():" + Thread.currentThread().getName() + " " + i + " " + j);
                                return j;
                            })
                            .publishOn(schedulerB)
                            .map(j -> {
                                System.out.println("nested 2nd map():" + Thread.currentThread().getName() + " " + i +
                                        " " + j);
                                return j;
                            })
                            .subscribe(j -> {
                                System.out.println("subscribe():" + Thread.currentThread().getName() + " " + i + " " + j);
                            });
                })
                .blockLast();
    }

    private void nestedTest2() {
        System.out.println("------ nestedTest2 ------");
        Flux.range(1, 3)
                .map(i -> {
                    System.out.println("1st map():" + Thread.currentThread().getName() + " " + i);
                    return i;
                })
                .subscribeOn(schedulerA)
                .map(i -> {
                    System.out.println("2nd map():" + Thread.currentThread().getName() + " " + i);
                    return Flux.fromIterable(Arrays.asList("A", "B"))
                            .map(j -> {
                                System.out.println("nested 1st map():" + Thread.currentThread().getName() + " " + i + " " + j);
                                return j;
                            })
                            .subscribeOn(schedulerB)
                            .map(j -> {
                                System.out.println("nested 2nd map():" + Thread.currentThread().getName() + " " + i +
                                        " " + j);
                                return j;
                            })
                            .subscribe(j -> {
                                System.out.println("subscribe():" + Thread.currentThread().getName() + " " + i + " " + j);
                            });
                })
                .blockLast();
    }

    private void nestedTest3() {
        System.out.println("------ nestedTest3 ------");
        Flux.range(1, 3)
                .map(i -> {
                    System.out.println("1st map():" + Thread.currentThread().getName() + " " + i);
                    return i;
                })
                .publishOn(schedulerA)
                .map(i -> {
                    System.out.println("2nd map():" + Thread.currentThread().getName() + " " + i);
                    return Flux.fromIterable(Arrays.asList("A", "B"))
                            .map(j -> {
                                System.out.println("nested 1st map():" + Thread.currentThread().getName() + " " + i + " " + j);
                                return j;
                            })
                            .subscribeOn(schedulerB)
                            .map(j -> {
                                System.out.println("nested 2nd map():" + Thread.currentThread().getName() + " " + i +
                                        " " + j);
                                return j;
                            })
                            .subscribe(j -> {
                                System.out.println("subscribe():" + Thread.currentThread().getName() + " " + i + " " + j);
                            });
                })
                .blockLast();
    }

    private void nestedTest4() {
        System.out.println("------ nestedTest4 ------");
        Flux.range(1, 3)
                .map(i -> {
                    System.out.println("1st map():" + Thread.currentThread().getName() + " " + i);
                    return i;
                })
                .subscribeOn(schedulerA)
                .map(i -> {
                    System.out.println("2nd map():" + Thread.currentThread().getName() + " " + i);
                    return Flux.fromIterable(Arrays.asList("A", "B"))
                            .map(j -> {
                                System.out.println("nested 1st map():" + Thread.currentThread().getName() + " " + i + " " + j);
                                return j;
                            })
                            .publishOn(schedulerB)
                            .map(j -> {
                                System.out.println("nested 2nd map():" + Thread.currentThread().getName() + " " + i +
                                        " " + j);
                                return j;
                            })
                            .subscribe(j -> {
                                System.out.println("subscribe():" + Thread.currentThread().getName() + " " + i + " " + j);
                            });
                })
                .blockLast();
    }
}
