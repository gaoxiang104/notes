package org.gx.onjava.chapter13_funcational;

import java.util.function.Function;
import java.util.function.IntToDoubleFunction;

public class FunctionWithWrapped {
    public static void main(String[] args) {
        Function<Integer, Double> fid = i -> (double) i;
        IntToDoubleFunction fid2 = i -> i;
    }
}
