package net.terzeron.javagrammar;

/**
 * Created by terzeron on 15. 10. 22..
 */
public class AbstractClassExample extends InfiniteBuffer {
    public char get() {
        return 'c';
    }

    public static void main(String[] args) {
        AbstractClassExample abstractClassExample = new AbstractClassExample();
        System.out.println(abstractClassExample.get());
    }
}
