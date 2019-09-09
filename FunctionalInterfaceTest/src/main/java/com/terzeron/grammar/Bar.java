package com.terzeron.grammar;

@FunctionalInterface
public interface Bar {
    String method(String str);
    default String defaultMethod() {
        return "String from Bar";
    }
}