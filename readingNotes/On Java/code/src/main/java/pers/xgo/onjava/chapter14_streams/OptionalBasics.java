package pers.xgo.onjava.chapter14_streams;

import java.util.Optional;
import java.util.stream.Stream;

public class OptionalBasics {
    static void test(Optional<String> optStr) {
        if (optStr.isPresent()) {
            System.out.println(optStr.get());
        } else {
            System.out.println("Nothing inside");
        }
    }

    public static void main(String[] args) {
        test(Stream.of("Epithets").findFirst());
        test(Stream.<String>empty().findFirst());
    }
}
/* output:
Epithets
Nothing inside
 */