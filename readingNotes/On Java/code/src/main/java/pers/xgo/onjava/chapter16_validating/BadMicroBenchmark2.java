package pers.xgo.onjava.chapter16_validating;
// 依赖于某个公共资源

import java.util.Arrays;
import java.util.Random;
import java.util.SplittableRandom;

public class BadMicroBenchmark2 { // 糟糕的微观基准
    static final int SIZE = 5_000_000;

    public static void main(String[] args) {
        try {
            long[] la = new long[SIZE];
            Random r = new Random();
            System.out.println("setALl: " + Timer.duration(() -> Arrays.setAll(la, n -> r.nextLong())));
            System.out.println("parallelSetAll: " + Timer.duration(() -> Arrays.parallelSetAll(la, n -> r.nextLong())));

            SplittableRandom sr = new SplittableRandom();
            System.out.println("setALl: " + Timer.duration(() -> Arrays.setAll(la, n -> sr.nextLong())));
            System.out.println("parallelSetAll: " + Timer.duration(() -> Arrays.parallelSetAll(la, n -> sr.nextLong())));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
