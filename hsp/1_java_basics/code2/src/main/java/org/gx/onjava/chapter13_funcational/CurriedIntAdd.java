package org.gx.onjava.chapter13_funcational;

import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;

public class CurriedIntAdd {
    public static void main(String[] args) {
        IntFunction<IntUnaryOperator> curriedInAdd =
                a -> b -> a + b;

        IntUnaryOperator add4 = curriedInAdd.apply(4);
        System.out.println(add4.applyAsInt(5));
    }
}
