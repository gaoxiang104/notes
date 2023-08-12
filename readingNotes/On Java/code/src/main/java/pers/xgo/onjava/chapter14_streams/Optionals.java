package pers.xgo.onjava.chapter14_streams;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Optionals {
    static void basics(Optional<String> optStr) {
        if (optStr.isPresent())
            System.out.println(optStr.get());
        else
            System.out.println("Nothing inside");
    }

    static void ifPresent(Optional<String> optStr) {
        optStr.ifPresent(System.out::println);
    }

    static void orElse(Optional<String> optStr) {
        System.out.println(optStr.orElse("NaDa"));
    }

    static void orElseGet(Optional<String> optStr) {
        System.out.println(
                optStr.orElseGet(() -> "Generated")
        );
    }

    static void orElseThrow(Optional<String> optStr) {
        try {
            System.out.println(
                    optStr.orElseThrow(() -> new Exception("Supplied"))
            );
        } catch (Exception e) {
            System.out.println("Caught " + e);
        }
    }

    static void test(String testName, Consumer<Optional<String>> cos) {
        System.out.println(" === " + testName + " === ");
        cos.accept(Stream.of("Epithets").findFirst());
        cos.accept(Stream.<String>empty().findFirst());
    }

    public static void main(String[] args) {
        test("basics", Optionals::basics);
        test("ifPresent", Optionals::ifPresent);
        test("orElse", Optionals::orElse);
        test("orElseGet", Optionals::orElseGet);
        test("orElseThrow", Optionals::orElseThrow);
    }
}
