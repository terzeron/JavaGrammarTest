package com.terzeron.grammar.lambda;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class FlatMappingCollectorTest {
    @AllArgsConstructor
    @Getter
    @Setter
    class Blog {
        private String authorName;
        private List<String> comments;
    }

    @Test
    public void givenListOfBlogs_whenAuthorName_thenMapAuthorWithComments() {
        Blog blog1 = new Blog("1", List.of("Nice", "Very Nice"));
        Blog blog2 = new Blog("2", List.of("Disappointing", "Ok", "Could be better"));
        List<Blog> blogs = List.of(blog1, blog2);

        Map<String, List<List<String>>> authorComments1 = blogs.stream()
                .collect(Collectors.groupingBy(Blog::getAuthorName, Collectors.mapping(Blog::getComments, Collectors.toList())));
        assertEquals(2, authorComments1.size());
        assertEquals(2, authorComments1.get("1").get(0).size());
        assertEquals(3, authorComments1.get("2").get(0).size());
    }
}
