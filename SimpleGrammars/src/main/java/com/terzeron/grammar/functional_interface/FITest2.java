package com.terzeron.grammar.functional_interface;

import java.util.function.Function;

class UseFoo2 {
    public String add(String string, Function<String, String> fn) {
        return fn.apply(string);
    }
}


public class FITest2 {
    public static void main(String[] args) {
        Function<String, String> stringConcatenate = parameter -> parameter + " from lambda";
        UseFoo2 useFoo = new UseFoo2();
        String result = useFoo.add("Message", stringConcatenate);
        System.out.println(result);
    }
}
