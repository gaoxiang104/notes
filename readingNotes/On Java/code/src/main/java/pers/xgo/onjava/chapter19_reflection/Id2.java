package pers.xgo.onjava.chapter19_reflection;

import java.util.stream.Stream;

public class Id2 {
    private static long counter;
    private final long id = counter++;

    @Override
    public String toString() {
        return Long.toString(id);
    }

    public static void main(String[] args) {
        Stream.generate(new DynamicSupplier<>(Id2.class)).skip(10).limit(5).forEach(System.out::println);
    }
}
