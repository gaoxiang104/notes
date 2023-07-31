package pers.xgo.onjava.chapter13_funcational;

import java.util.function.IntSupplier;

public class Closure6 {
    IntSupplier makeFun(int x) {
        int i = 0;
        x++;
        i++;
        final int iFinal = i;
        final int xFinal = x;
        return () -> xFinal + iFinal;
    }
}
