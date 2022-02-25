package com.terzeron.grammar.optional;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

// https://www.baeldung.com/java-optional
public class OfAndOfNullableTest {
    @Test
    // empty optional을 생성하면 -> 성공
    public void whenCreatesEmptyOptional_thenCorrect() {
        Optional<String> empty = Optional.empty();
        assertFalse(empty.isPresent());
    }

    @Test
    // non null이 주어졌을 때 -> non null optional을 생성하면 -> 성공
    public void givenNonNull_whenCreatesNonNullable_thenCorrect() {
        String name = "baeldung";
        Optional<String> opt = Optional.of(name);
        assertTrue(opt.isPresent());
    }

    @Test
    // null이 주어졌을 때 -> NPE을 던지면 -> 성공
    public void givenNull_whenThrowsErrorOnCreate_thenCorrect() {
        assertThrows(NullPointerException.class, () -> {
            String name = null;
            Optional.of(name);
        });
    }

    // of():
    //   non null만 받음
    // ofNullable():
    //   non null이면 그 값을 가지는 optional을 반환, null이면 empty optional을 반환
    //   null이 될 수 있는 변수를 받을 수는 있지만 직접적으로 null을 받지 않음

    @Test
    // null이 주어졌을 때 -> nullable optional을 생성하지 않으면(empty optional이 생성되면) -> 성공
    public void givenNull_whenCreatesNullable_thenCorrect() {
        String name = null;
        Optional<String> opt = Optional.ofNullable(name);
        assertFalse(opt.isPresent());
    }

    @Test
    // non null이 주어졌을 때 -> nullable이라고 간주하고 optional을 생성하면 -> 성공
    public void givenNonNull_whenCreatesNullable_thenCorrect() {
        String name = "baeldung";
        Optional<String> opt = Optional.ofNullable(name);
        assertTrue(opt.isPresent());
    }

}
