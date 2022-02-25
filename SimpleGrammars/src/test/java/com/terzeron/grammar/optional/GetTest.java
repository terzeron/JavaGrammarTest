package com.terzeron.grammar.optional;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GetTest {
    @Test
    public void givenOptional_whenGetsValue_thenCorrect() {
        Optional<String> opt = Optional.of("baeldung");
        String name = opt.get();
        assertEquals("baeldung", name);
    }

    @Test
    public void givenOptionalWithNull_whenGetThrowsException_thenCorrect() {
        assertThrows(NoSuchElementException.class, () -> {
            Optional<String> opt = Optional.ofNullable(null);
            String name = opt.get();
        });
    }
}

