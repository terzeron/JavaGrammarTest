package com.terzeron.grammar;

import java.util.function.Function;

public class UseFooExtended {
    public String add(final String str, final FooExtended foo) {
        return foo.method(str);
    }

    public String addWithStandardFI(final String string, final Function<String, String> fn) {
        return fn.apply(string);
    }
}
