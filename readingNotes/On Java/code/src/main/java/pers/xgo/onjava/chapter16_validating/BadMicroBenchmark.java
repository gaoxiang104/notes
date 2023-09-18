package pers.xgo.onjava.chapter16_validating;

import java.util.Arrays;

public class BadMicroBenchmark { // 糟糕的微观基准
    static final int SIZE = 250_000_000;

    public static void main(String[] args) {
        try {
            long[] la = new long[SIZE];
            System.out.println("setALl: " + Timer.duration(() -> Arrays.setAll(la, n -> n)));
            System.out.println("parallelSetAll: " + Timer.duration(() -> Arrays.parallelSetAll(la, n -> n)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
