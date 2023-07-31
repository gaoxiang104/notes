package pers.xgo.onjava.chapter13_funcational;

import java.util.function.IntSupplier;

public class Closure5 {
    IntSupplier makeFun(int x) {
        int i = 0;
        x++;
        i++;
        // 错误：Variable used in lambda expression should be final or effectively final
        // return () -> x + i;
        return () -> 0;
    }
}
