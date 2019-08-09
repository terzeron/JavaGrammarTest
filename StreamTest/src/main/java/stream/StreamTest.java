package stream;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import java.util.stream.*;

public class StreamTest {
    static Logger log = Logger.getLogger("StreamTest");

    public static Stream<String> streamOf(List<String> list) {
        return (list == null || list.isEmpty()) ? Stream.empty() : list.stream();
    }

    private static void print_horizontal_dash() {
        System.out.println("--------------------------------------------------------");
    }

    private static long counter;

    private static void wasCalled() {
        counter++;
    }

    public static void main(String[] args) {
        // collection to stream
        Stream<String> streamEmpty = Stream.empty();
        List<String> list1 = Arrays.asList("a", "b", "c");
        streamOf(list1);
        Stream<String> streamOfCollection = list1.stream();
        print_horizontal_dash();
        streamOfCollection.forEach(System.out::println);

        // builder
        Stream<String> streamBuilder = Stream.<String>builder().add("a").add("b").add("c").build();
        print_horizontal_dash();
        streamBuilder.forEach(System.out::println);

        // generate
        Stream<String> streamGenerated = Stream.generate(() -> "element").limit(3);
        print_horizontal_dash();
        streamGenerated.forEach(System.out::println);

        // iterate
        Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(4);
        print_horizontal_dash();
        streamIterated.forEach(System.out::println);

        // primitives
        IntStream intStream = IntStream.range(1, 3);
        LongStream longStream = LongStream.rangeClosed(1, 3);
        Random random = new Random();
        DoubleStream doubleStream = random.doubles(3);
        print_horizontal_dash();
        intStream.forEach(System.out::println);
        print_horizontal_dash();
        longStream.forEach(System.out::println);
        print_horizontal_dash();
        doubleStream.forEach(System.out::println);

        // stream of string
        IntStream streamOfChars = "abc".chars();
        Stream<String> streamOfString = Pattern.compile(", ").splitAsStream("a, b, c");
        print_horizontal_dash();
        streamOfChars.forEach(System.out::println);
        print_horizontal_dash();
        streamOfString.forEach(System.out::println);

        // stream of file
        Path path = Paths.get("file.txt");
        try {
            Stream<String> streamOfStrings = Files.lines(path);
            Stream<String> streamWithCharset = Files.lines(path, Charset.forName("UTF-8"));
            print_horizontal_dash();
            streamOfStrings.forEach(System.out::println);
            print_horizontal_dash();
            streamWithCharset.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // referencing
        Stream<String> stream = Stream.of("ab", "b", "c", "b").filter(element -> element.contains("b"));
        Optional<String> anyElement = stream.findAny(); // no guarantee for the encounter order
        print_horizontal_dash();
        anyElement.ifPresent(System.out::println);

        stream = Stream.of("a", "b", "c").filter(element -> element.contains("b") || element.contains("a"));
        Optional<String> firstElement = stream.findFirst(); // guarantee for the encounter order
        print_horizontal_dash();
        firstElement.ifPresent(System.out::println);

        List<String> elements =
                Stream.of("a", "c", "b", "c").filter(element -> element.contains("c")).collect(Collectors.toList());
        Optional<String> anyElement1 = elements.stream().findAny();
        Optional<String> firstElement1 = elements.stream().findFirst();
        print_horizontal_dash();
        anyElement1.ifPresent(System.out::println);
        print_horizontal_dash();
        firstElement1.ifPresent(System.out::println);

        // pipeline
        Stream<String> onceModifiedStream = Stream.of("abcd", "bbcd", "cdcd").skip(1);
        print_horizontal_dash();
        onceModifiedStream.forEach(System.out::println);
        onceModifiedStream = Stream.of("abcd", "bbcd", "cdcd").skip(1);
        Stream<String> twiceModifiedStream = onceModifiedStream.skip(1).map(element -> element.substring(0, 3));
        print_horizontal_dash();
        twiceModifiedStream.forEach(System.out::println);

        List<String> list = Arrays.asList("abc1", "abc2", "abc3");
        long size = list.stream().skip(1).map(element -> element.substring(0, 3)).sorted().count();
        print_horizontal_dash();
        System.out.println(size);

        // lazy invocation
        List<String> list2 = Arrays.asList("abc1", "abc2", "abc3");
        counter = 0;
        Stream<String> stream2 = list2.stream().filter(element -> {
            wasCalled();
            return element.contains("2");
        });
        print_horizontal_dash();
        stream2.forEach(System.out::println);

        print_horizontal_dash();
        Optional<String> stream3 = list.stream().filter(element -> {
            System.out.println("filter() was called");
            return element.contains("2");
        }).map(element -> {
            System.out.println("map() was called");
            return element.toUpperCase();
        }).findFirst();
        stream3.ifPresent(System.out::println);

        // order of execution
        counter = 0;
        List<String> list3 = Arrays.asList("abc1", "abc2", "abc3");
        long size3 = list3.stream().map(element -> {
            wasCalled();
            return element.substring(0, 3);
        }).skip(2).count();
        print_horizontal_dash();
        System.out.println(size3);
        System.out.println(counter); // count of being called

        counter = 0;
        List<String> list4 = Arrays.asList("abc1", "abc2", "abc3");
        long size4 = list4.stream().skip(2).map(element -> {
            wasCalled();
            return element.substring(0, 3);
        }).count();
        print_horizontal_dash();
        System.out.println(size4);
        System.out.println(counter); // count of being called

        // reduction
        print_horizontal_dash();
        OptionalInt reduced = IntStream.range(1, 4).reduce((a, b) -> a + b);
        reduced.ifPresent(System.out::println); // 1 + 2 + 3
        print_horizontal_dash();
        int reducedTwoParams = IntStream.range(1, 4).reduce(20, (a, b) -> {
            System.out.println("reduce: a=" + a + ",b=" + b);
            return a + b;
        });
        System.out.println(reducedTwoParams); // 20 + (1 + 2 + 3)

        print_horizontal_dash();
        int reducedParallel = Arrays.asList(1, 2, 3).parallelStream().reduce(10,
                /* accumulator */ (a, b) -> {
                    System.out.println("parallelStream().accumulator: a=" + a + ",b=" + b);
                    return a + b;
                },
                /* combiner  */ (a, b) -> {
                    System.out.println("parallelStream().combiner: a=" + a + ",b=" + b);
                    return a + b;
                });
        System.out.println(reducedParallel);
    }
}
