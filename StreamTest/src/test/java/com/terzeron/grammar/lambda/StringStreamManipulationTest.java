package com.terzeron.grammar.lambda;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringStreamManipulationTest {
    @Test
    public void givenArray_transformedToStream_convertToString() {
        String[] stringArray = new String[]{"hello", "world", "music", "coffee"};
        String expectation = "hello,world,music,coffee";
        String result = StringStreamManipulation.join(stringArray);
        assertEquals(result, expectation);
    }

    @Test
    public void givenArray_transformedToStream_convertToStringWithPrefixPostfix() {
        String[] programmingLanguages = {"java", "python", "nodejs", "ruby"};
        String expectation = "[java,python,nodejs,ruby]";
        String result = StringStreamManipulation.joinWithPrefixPostFix(programmingLanguages);
        assertEquals(result, expectation);
    }

    @Test
    public void givenString_transformedToStream_convertToList() {
        String programmingLanguages = "java,python,nodejs,ruby";
        List<String> expectation = List.of("java", "python", "nodejs", "ruby");
        List<String> result = StringStreamManipulation.split(programmingLanguages);
        assertEquals(result, expectation);
    }

    @Test
    public void givenString_transformedToStream_converToListOfChar() {
        String word = "hello";
        List<Character> expectation = List.of('h', 'e', 'l', 'l', 'o');
        List<Character> result = StringStreamManipulation.splitToListOfChar(word);
        assertEquals(result, expectation);
    }

    @Test
    public void givenStringArrayDelimitedByColon_transformedToStream_convertToMapOfStringString() {
        String[]stringArrayDelimitedByColon = new String[]{"language:java","os:linux","editor:emacs"};
        Map<String, String> expectation = Map.of("language", "java", "os", "linux", "editor", "emacs");
        Map<String, String> result = StringStreamManipulation.arrayToMap(stringArrayDelimitedByColon);
        assertEquals(result, expectation);
    }
}
