package com.terzeron.grammar.virtual_extension_methods1;

/**
 * Created by terzeron on 2017. 10. 23..
 */
interface TestInterface {
    void testMe();

    default void aDefaulter() {
        System.out.println("default from interface");
    }
}
