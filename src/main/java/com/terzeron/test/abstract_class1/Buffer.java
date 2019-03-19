package com.terzeron.test.abstract_class1;

/**
 * Created by terzeron on 15. 10. 22..
 */
public interface Buffer {
    char get() throws BufferEmpty, BufferError;
}
