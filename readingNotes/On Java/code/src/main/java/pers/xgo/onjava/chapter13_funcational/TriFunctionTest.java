package pers.xgo.onjava.chapter13_funcational;

public class TriFunctionTest {
    static int f(int i, long l, double d) {
        return 99;
    }

    public static void main(String[] args) {
        TirFunction<Integer, Long, Double, Integer> tf
                = TriFunctionTest::f; // 方法引用

        tf = (i, l, d) -> 12; // lambda 表达式
    }
}
