package com.terzeron.grammar;

import java.util.function.Function;

public class UseFoo {
    public String add(final String str, final Foo foo) {
        return foo.method(str);
    }

    public String addWithStandardFI(final String string, final Function<String, String> fn) {
        return fn.apply(string);
    }
}
