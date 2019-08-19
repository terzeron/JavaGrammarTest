package stream;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class ParallelReductionTest {
    private static void print_horizontal_dash() {
        System.out.println("--------------------------------------------------------");
    }

    public static void main(String[] args) {
        // reduction
        print_horizontal_dash();
        OptionalInt reduced = IntStream.range(1, 4).reduce((a, b) -> a + b);
        reduced.ifPresent(System.out::println); // 1 + 2 + 3
        print_horizontal_dash();
        int reducedTwoParams = IntStream.range(1, 4).reduce(20, (a, b) -> {
            System.out.println("reduce: a=" + a + ",b=" + b);
            return a + b;
        });
        System.out.println(reducedTwoParams); // (((20 + 1) + 2) + 3)

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
        // 10 + 1 -> 11
        // 10 + 2 -> 12
        // 10 + 3 -> 13 ... 12 + 13 -> 25 ... 25 + 11 -> 36
    }
}


