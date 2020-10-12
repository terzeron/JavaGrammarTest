package com.terzeron.grammar.lambda;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class HumanTest {
    private static List<Human> humans;

    @BeforeAll
    public static void init() {
        humans = Lists.newArrayList(
                new Human("Sarah", 10),
                new Human("Jack", 12)
        );
    }

    @Test
    public void whenSortingEntitiesByName_thenCorrectlySorted() {
        humans.sort(
                (Human h1, Human h2) -> h1.getName().compareTo(h2.getName())
        );
        assertEquals(humans.get(0).getName(), "Jack");
    }

    @Test
    public void givenLambdaShortForm_whenSortingEntitiesByName_thenCorrectlySorted() {
        humans.sort((h1, h2) -> h1.getName().compareTo(h2.getName()));
        assertEquals(humans.get(0).getName(), "Jack");
    }

    @Test
    public void
    givenMethodDefinition_whenSortingEntitiesByNameThenAge_thenCorrectlySorted() {
        humans.sort(Human::compareByNameThenAge);
        assertEquals(humans.get(0).getName(), "Jack");
    }

    @Test
    public void givenInstanceMethod_whenSortingEntitiesByName_thenCorrectlySorted1() {
        Collections.sort(humans, Comparator.comparing(Human::getName));
        assertEquals(humans.get(0).getName(), "Jack");
    }

    @Test
    public void givenInstanceMethod_whenSortingEntitiesByName_thenCorrectlySorted2() {
        Collections.sort(humans, Comparator.comparing(Human::getName));
        assertEquals(humans.get(0).getName(), "Jack");
    }

    // reverse sort
    @Test
    public void whenSortingEntitiesByNameReversed_thenCorrectlySorted() {
        Comparator<Human> comparator
                = (h1, h2) -> h1.getName().compareTo(h2.getName());
        humans.sort(comparator.reversed());
        assertEquals(humans.get(humans.size() - 1).getName(), "Jack");
    }

    // with multiple condition
    @Test
    public void whenSortingEntitiesByNameThenAge_thenCorrectlySorted() {
        humans.sort((lhs, rhs) -> {
            if (lhs.getName().equals(rhs.getName())) {
                return Integer.compare(lhs.getAge(), rhs.getAge());
            } else {
                return lhs.getName().compareTo(rhs.getName());
            }
        });
        assertEquals(humans.get(0).getName(), "Jack");
    }

    // with multiple condition: composition
    @Test
    public void givenComposition_whenSortingEntitiesByNameThenAge_thenCorrectlySorted() {
        humans.sort(
                Comparator.comparing(Human::getName).thenComparing(Human::getAge)
        );
        assertEquals(humans.get(0).getName(), "Jack");
    }

    @Test
    public final void givenStreamNaturalOrdering_whenSortingEntitiesByName_thenCorrectlySorted() {
        Comparator<Human> nameComparator = (h1, h2) -> h1.getName().compareTo(h2.getName());
        List<Human> sortedHumans = humans.stream().sorted(nameComparator).collect(Collectors.toList());
        // stream().sorted()를 사용하게 되면 결과를 저장할 새로운 컬렉션이 필요함
        assertEquals(sortedHumans.get(0).getName(), "Jack");
    }

    @Test
    public final void givenStreamComparatorOrdering_whenSortingEntitiesByName_thenCorrectlySorted() {
        // stream().sorted(comparing()) 이용
        List<Human> sortedHumans = humans.stream()
                .sorted(Comparator.comparing(Human::getName))
                .collect(Collectors.toList());
        assertEquals(sortedHumans.get(0).getName(), "Jack");
    }
    
    @Test
    public final void givenStreamComparatorOrdering_whenSortingEntitiesByNameReversed_thenCorrectlySorted() {
        // stream().sorted(comparing()) 이용 + reverse order
        List<Human> sortedHumans = humans.stream()
                .sorted(Comparator.comparing(Human::getName, Comparator.reverseOrder()))
                .collect(Collectors.toList());
        assertEquals(sortedHumans.get(sortedHumans.size() - 1).getName(), "Jack");
    }

    @Test
    public void zzzWillBeExecutedLastly_givenANullElement_whenSortingEntitiesByName_thenMovesTheNullToLast() {
        humans.add(null);

        humans.sort(Comparator.nullsLast(Comparator.comparing(Human::getName)));
        assertEquals(humans.get(0).getName(), "Jack");
    }
}