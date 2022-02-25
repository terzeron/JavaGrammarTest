package com.terzeron.grammar.optional;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OrElseTest {
    private String getMyDefault() {
        System.out.println("Getting my default value...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "heavy value";
    }

    @Test
    public void whenOrElseWorks_thenCorrect() {
        String nullName = null;
        // orElse():
        //   디폴트값 처리하는 메소드
        //   파라미터로 값을 받음
        //   early evaluation
        String name = Optional.ofNullable(nullName).orElse("john");
        assertEquals("john", name);
    }

    @Test
    public void whenOrElseGetWorks_thenCorrect() {
        String nullName = null;
        // orElse():
        //   디폴트값 처리하는 메소드
        //   파라미터로 Supplier를 받음
        //   lazy evaluation
        String name = Optional.ofNullable(nullName).orElseGet(() -> "john");
        assertEquals("john", name);
    }

    @Test
    public void whenOrElseAndOrElseGetWorks_thenCorrect() {
        System.out.println("orElse():");
        Optional.ofNullable("hello world").orElse(getMyDefault());
        System.out.println("orElseGet():");
        // null이 아니므로 orElseGet의 파라미터 lambda는 실행되지 않음
        Optional.ofNullable("hello world").orElseGet(() -> getMyDefault());
    }

    @Test
    public void whenOrElseThrowWorks_thenCorrect() {
        assertThrows(IllegalArgumentException.class, () -> {
            String nullName = null;
            // orElseThrow():
            //   Optional이 null이면 예외 던짐
            String name = Optional.ofNullable(nullName).orElseThrow(IllegalArgumentException::new);
        });
    }

    @Test
    public void whenNoArgOrElseThrowWorks_thenCorrect() {
        assertThrows(NoSuchElementException.class, () -> {
            String nullName = null;
            String name = Optional.ofNullable(nullName).orElseThrow();
        });
    }
}
