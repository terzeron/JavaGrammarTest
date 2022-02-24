package com.terzeron.grammar.lambda1.lambda;

import io.vavr.CheckedFunction1;
import io.vavr.Value;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ExceptionTest {
    private static Integer readFromFile(Integer integer) throws IOException {
        //System.out.println("integer:" + integer);
        if (integer > 10) {
            throw new IOException("fake io exception");
        }
        return integer + 1;
    }

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(3, 9, 7, 0, 10, 20);
        /*CheckedFunction1<Integer, Integer> readFunction = i -> readFromFile(i);*/
        CheckedFunction1<Integer, Integer> readFunction = ExceptionTest::readFromFile;

        // 1) 정석대로 예외 처리한다면 다음과 같이
        System.out.println("-------- 1 --------");
        integers.stream()
                .map(i -> {
                        Integer ret = -1;
                        try {
                            ret = readFromFile(i);
                        } catch (IOException e) {
                            System.out.println("exception caught");
                        }
                        return ret;
                    }
                )
                .forEach(System.out::println);

        // 2) lifting을 이용하여 처리하려면
        System.out.println("-------- 2 --------");
        integers.stream()
                .map(CheckedFunction1.lift(ExceptionTest::readFromFile))
                .map(k -> k.getOrElse(-1)) // 예외 발생 시 default value 처리
                .forEach(System.out::println);

        // 3) liftTry를 이용하여 처리하려면
        System.out.println("-------- 3 --------");
        integers.stream()
                .map(CheckedFunction1.liftTry(ExceptionTest::readFromFile))
                .flatMap(Value::toJavaStream) // 이 변환이 없으면 값 대신 Success or Failure 타입으로 반환됨
                .forEach(System.out::println);

        // 4) unchecked()를 이용하여 예외가 발생하는 것을 내버려두려면
        System.out.println("-------- 4 --------");
        integers.stream()
                .map(readFunction.unchecked())
                .forEach(System.out::println);
    }
}
