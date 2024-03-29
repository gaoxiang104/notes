package pers.xgo.onjava.chapter14_streams;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class OptionalFilter {
    static String[] elements = {"Foo", "", "Bar", "Baz", "Bingo"};

    static Stream<String> testStream() {
        return Arrays.stream(elements);
    }

    static void test(String descr, Predicate<String> pred) {
        System.out.println(" ---( " + descr + " )--- ");
        for (int i = 0; i < elements.length; i++) {
            System.out.println(
                    testStream().skip(i)
                            .findFirst()
                            .filter(pred)
            );
        }
    }

    public static void main(String[] args) {
        test("true", str -> true);
        test("false", str -> false);
        test("str != \"\"", str -> str != "");
        test("str.length() == 3", str -> str.length() == 3);
        test("startsWith(\"B\")", str -> str.startsWith("B"));
    }
}
/* OUTPUT:
 ---( true )---
Optional[Foo]
Optional[]
Optional[Bar]
Optional[Baz]
Optional[Bingo]
 ---( false )---
Optional.empty
Optional.empty
Optional.empty
Optional.empty
Optional.empty
 ---( str != "" )---
Optional[Foo]
Optional.empty
Optional[Bar]
Optional[Baz]
Optional[Bingo]
 ---( str.length() == 3 )---
Optional[Foo]
Optional.empty
Optional[Bar]
Optional[Baz]
Optional.empty
 ---( startsWith("B") )---
Optional.empty
Optional.empty
Optional[Bar]
Optional[Baz]
Optional[Bingo]
 */