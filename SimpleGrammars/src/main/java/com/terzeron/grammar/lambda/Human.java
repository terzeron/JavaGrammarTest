package com.terzeron.grammar.lambda;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Human {
    private String name;
    private int age;
    
    public static int compareByNameThenAge(Human lhs, Human rhs) {
        if (lhs.getName().equals(rhs.getName())) {
            return Integer.compare(lhs.getAge(), rhs.getAge());
        } else {
            return lhs.getName().compareTo(rhs.getName());
        }
    }
}
