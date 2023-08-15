package pers.xgo.onjava.chapter14_streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapCollector3 {
    public static void main(String[] args) {
        record Foo(int id, String name) {
        }

        List<Foo> fooList = Arrays.asList(
                new Foo(1, "Alice"),
                new Foo(2, "Bob"),
                new Foo(3, "Charlie"),
                new Foo(2, "David")
        );

        Map<Integer, Foo> fooMap = fooList.stream()
                .collect(Collectors.toMap(Foo::id,
                        foo -> foo,
                        (existing, replacement) -> { // 替换策略
                            System.out.println("Merging: " + existing.name + " and " + replacement.name());
                            return replacement; // 替换
                        }));

        fooMap.forEach((id, foo) -> System.out.println(id + " : " + foo.name));
    }
}
/* OUTPUT：
Merging: Bob and David
1 : Alice
2 : David
3 : Charlie
 */