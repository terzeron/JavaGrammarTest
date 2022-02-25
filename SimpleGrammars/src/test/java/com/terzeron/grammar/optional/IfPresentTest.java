package com.terzeron.grammar.optional;

import org.junit.jupiter.api.Test;

import java.util.Optional;

public class IfPresentTest {
    @Test
    public void givenOptional_whenIfPresentWorks_thenCorrect() {
        Optional<String> opt = Optional.of("baeldung");
        // ifPresent():
        //   null이 아닌 경우 lambda(Consumer) 수행
        opt.ifPresent(name -> System.out.println(name.length()));
    }
}
