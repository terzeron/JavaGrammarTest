package flow2;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MyPublisher pub = new MyPublisher();
        MySubscriber sub = new MySubscriber();
        sub.setDEMAND(3);

        MyProcessor proc = new MyProcessor();
        proc.setDEMAND(3);

        pub.subscribe(proc);
        proc.subscribe(sub);

        pub.waitUntilTerminated();
    }
}
