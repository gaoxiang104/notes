package pers.xgo.onjava.chapter14_streams;

import java.util.stream.Stream;

public class Duplicator {
    public static void main(String[] args) {
        Stream.generate(() -> "duplicate")
                .limit(3)
                .forEach(System.out::println);
    }
}
