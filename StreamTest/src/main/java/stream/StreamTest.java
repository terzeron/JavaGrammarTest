package stream;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamTest {
    public static Stream<String> streamOf(List<String> list) {
        return list == null || list.isEmpty() ? Stream.empty() : list.stream();
    }

    public static void main(String[] args) {
        // collection to stream
        Stream<String> streamEmpty = Stream.empty();
        List<String> list1 = Arrays.asList("a", "b", "c");
        streamOf(list1);
        Stream<String> streamOfCollection = list1.stream();
        System.out.println("----------------------------");
        streamOfCollection.forEach(System.out::println);

        // builder
        Stream<String> streamBuilder = Stream.<String>builder().add("a").add("b").add("c").build();
        System.out.println("----------------------------");
        streamBuilder.forEach(System.out::println);

        // generate
        Stream<String> streamGenerated = Stream.generate(() -> "element").limit(5);
        System.out.println("----------------------------");
        streamGenerated.forEach(System.out::println);

        // iterate
        Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(5);
        System.out.println("----------------------------");
        streamIterated.forEach(System.out::println);

        // primitives
        IntStream intStream = IntStream.range(1, 3);
        LongStream longStream = LongStream.rangeClosed(1, 3);
        Random random = new Random();
        DoubleStream doubleStream = random.doubles(3);
        System.out.println("----------------------------");
        intStream.forEach(System.out::println);
        longStream.forEach(System.out::println);
        doubleStream.forEach(System.out::println);

        // stream of string
        IntStream streamOfChars = "abc".chars();
        Stream<String> streamOfString = Pattern.compile(", ").splitAsStream("a, b, c");
        System.out.println("----------------------------");
        streamOfChars.forEach(System.out::println);
        streamOfString.forEach(System.out::println);

        // stream of file
        Path path = Paths.get("file.txt");
        try {
            Stream<String> streamOfStrings = Files.lines(path);
            Stream<String> streamWithCharset = Files.lines(path, Charset.forName("UTF-8"));
            System.out.println("----------------------------");
            streamOfStrings.forEach(System.out::println);
            streamWithCharset.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
