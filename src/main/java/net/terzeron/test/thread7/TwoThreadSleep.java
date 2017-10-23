package net.terzeron.test.thread7;

public class TwoThreadSleep extends Thread {
    public void run() {
        loop();
    }

    public void loop() {
        Thread t = Thread.currentThread();
        String name = t.getName();
        
        System.out.println("just entered loop() - " + name);
        
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException x) {
            }

            System.out.println("name=" + name);
        }
        
        System.out.println("about to leave loop() - " + name);
    }
    
    public static void main(String [] args) {
        TwoThreadSleep tt = new TwoThreadSleep();
        tt.setName("my worker thread");
        tt.start();

        try {
            Thread.sleep(7000);
        } catch (InterruptedException x) {
        }
        
        tt.loop();
    }
}
