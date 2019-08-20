package com.terzeron.grammar.class_for_name;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by terzeron on 2016. 8. 11..
 */
@Slf4j
public class ClassForNameTest {
    public static void main(String[] args) {
        try {
            // explicitly load class using forName()
            Class.forName("com.terzeron.grammar.class_for_name.One");
        } catch (ClassNotFoundException e) {
            log.error(e.getMessage(), e);
        }

        try {
            // wrong way of specifying class name
            // It must be fully qualified path
            Class.forName("Two");
        } catch (ClassNotFoundException e) {
            log.error(e.getMessage(), e);
        }

        try {
            // explicitly load class using forName()
            Class.forName("com.terzeron.grammar.class_for_name.Two");
        } catch (ClassNotFoundException e) {
            log.error(e.getMessage(), e);
        }

        // create instance
        new Three();
    }
}

class One {
    static {
        System.out.println("class One loaded");
    }
}

class Two {
    static {
        System.out.println("class Two loaded");
    }
}

class Three {
    static {
        System.out.println("class Three loaded");
    }
}
