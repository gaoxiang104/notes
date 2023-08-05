package pers.xgo.onjava.chapter14_streams;

import java.util.stream.Stream;

public class Fibonacci {
    static int x = 1;

    public static void main(String[] args) {
        Stream.iterate(0, i -> {
                    int result = x + i;
                    x = i;
                    return result;
                }).skip(20) // 不使用前20个
                .limit(10) // 然后从中取10个
                .forEach(System.out::println);
    }
}
