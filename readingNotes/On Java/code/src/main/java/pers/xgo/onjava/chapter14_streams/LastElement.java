package pers.xgo.onjava.chapter14_streams;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LastElement {
    public static void main(String[] args) {
        // 数值
        OptionalInt last = IntStream.range(10, 20)
                .reduce((n1, n2) -> n2);
        System.out.println(last.orElse(-1));
        // 非数值
        Optional<String> lastObj =
                Stream.of("one", "two", "three")
                        .reduce((s1, s2) -> s2);
        System.out.println(lastObj.orElse("null"));
    }
}
