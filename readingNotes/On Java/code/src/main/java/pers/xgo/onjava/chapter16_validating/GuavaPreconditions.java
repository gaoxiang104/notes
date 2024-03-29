package pers.xgo.onjava.chapter16_validating;

// 演示 Guava 的前置条件测试

import static com.google.common.base.Preconditions.*;

import java.util.function.Consumer;

public class GuavaPreconditions {
    static void test(Consumer<String> c, String s) {
        try {
            System.out.println(s);
            c.accept(s);
            System.out.println("Success");
        } catch (Exception e) {
            String type = e.getClass().getSimpleName();
            String msg = e.getMessage();
            System.out.println(type + (msg == null ? "" : " : " + msg));
        }
    }

    public static void main(String[] args) {
        test(s -> s = checkNotNull(s), "X");
        test(s -> s = checkNotNull(s), null);
        test(s -> s = checkNotNull(s, "s was null"), null);
        test(s -> s = checkNotNull(s, "s was null , %s %s", "arg2", "arg3"), null);
        test(s -> checkArgument(s == "Fozzie"), "Fozzie");
        test(s -> checkArgument(s == "Fozzie"), "X");
        test(s -> checkArgument(s == "Fozzie"), null);
        test(s -> checkArgument(s == "Fozzie", "Bear Left!"), null);
        test(s -> checkArgument(s == "Fozzie", "Bear Left! %s Right!", "Frog"), null);
        test(s -> checkState(s.length() > 6), "Mortimer");
        test(s -> checkState(s.length() > 6), "Mort");
        test(s -> checkState(s.length() > 6), null);

        test(s -> checkElementIndex(6, s.length()), "Robert");
        test(s -> checkElementIndex(6, s.length()), "Bob");
        test(s -> checkElementIndex(6, s.length()), null);

        test(s -> checkPositionIndex(6, s.length()), "Robert");
        test(s -> checkPositionIndex(6, s.length()), "Bob");
        test(s -> checkPositionIndex(6, s.length()), null);

        test(s -> checkPositionIndexes(0, 6, s.length()), "Hieronymus");
        test(s -> checkPositionIndexes(0, 10, s.length()), "Hieronymus");
        test(s -> checkPositionIndexes(0, 11, s.length()), "Hieronymus");
        test(s -> checkPositionIndexes(-1, 6, s.length()), "Hieronymus");
        test(s -> checkPositionIndexes(7, 6, s.length()), "Hieronymus");
        test(s -> checkPositionIndexes(0, 6, s.length()), null);
    }
}
