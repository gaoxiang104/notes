package org.gx.onjava.chapter13_funcational;
// {无法通过编译}
import java.util.function.IntSupplier;

public class Closure7 {
    IntSupplier makeFun(int x) {
        int i = 0;
        i = i + 1;
        // return () -> x + i;
        return () -> 0;
    }
}
