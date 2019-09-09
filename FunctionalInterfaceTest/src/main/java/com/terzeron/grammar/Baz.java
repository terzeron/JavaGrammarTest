package com.terzeron.grammar;

@FunctionalInterface
public interface Baz {
    String method(String str);
    default String defaultMethod() {
        return "String from Baz";
    }
}