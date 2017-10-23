package net.terzeron.javagrammar;

/**
 * Created by terzeron on 15. 10. 22..
 */
public interface Buffer {
    char get() throws BufferEmpty, BufferError;
}
