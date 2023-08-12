package pers.xgo.onjava.chapter14_streams;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

public class OptionalMap {
    static String[] elements = {"12", "", "23", "45"};

    static Stream<String> testStream() {
        return Arrays.stream(elements);
    }

    static void test(String descr, Function<String, String> func) {
        System.out.println(" ---( " + descr + " )--- ");
        for (int i = 0; i < elements.length; i++) {
            System.out.println(
                    testStream().skip(i)
                            .findFirst()
                            .map(func)
            );
        }
    }

    public static void main(String[] args) {
        // 如果 Optional 不为 empty ，在将其传给函数时，map() 首先会提取 Optional 中的对象：
        test("Add brackets", s -> "[" + s + "]");

        test("Increment", s -> {
            try {
                return Integer.parseInt(s) + 1 + "";
            } catch (NumberFormatException e) {
                return s;
            }
        });

        test("Replace", s -> s.replace("2", "9"));

        test("Take last digit", s -> s.length() > 0 ? s.charAt(s.length() - 1) + "" : s);

        // 在函数完成后，map() 会先把结果包在一个 Optional中，然后返回
    }
}
