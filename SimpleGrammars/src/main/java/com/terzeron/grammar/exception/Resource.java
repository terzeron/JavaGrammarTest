package com.terzeron.grammar.exception;

/**
 * Created by terzeron on 2015-12-17.
 */

public class Resource implements AutoCloseable {
    public void use() {
        throw new RuntimeException("This com.terzeron.grammar.exception in the use method");
    }

    @Override
    public void close() throws Exception {
        throw new NullPointerException("This com.terzeron.grammar.exception in the close method");
    }
}
