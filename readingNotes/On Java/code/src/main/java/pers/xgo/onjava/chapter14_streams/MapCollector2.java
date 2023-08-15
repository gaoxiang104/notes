package pers.xgo.onjava.chapter14_streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapCollector2 {
    public static void main(String[] args) {
        record Foo(int id, String name) {
        }

        List<Foo> fooList = Arrays.asList(
                new Foo(1, "Alice"),
                new Foo(2, "Bob"),
                new Foo(3, "Charlie")
        );

        Map<Integer, Foo> fooMap = fooList.stream()
                .collect(Collectors.toMap(Foo::id, foo -> foo));
        System.out.println(fooMap);
    }
}
