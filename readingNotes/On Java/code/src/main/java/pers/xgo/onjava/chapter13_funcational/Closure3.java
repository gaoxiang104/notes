package pers.xgo.onjava.chapter13_funcational;

import java.util.function.IntSupplier;

public class Closure3 {
    IntSupplier makeFun(int x) {
        int i = 0;
        // x++ 或 i++ 都不可以；
        // return () -> x++ + i++;
        return () -> 0;
    }
}
