package pers.xgo.onjava.chapter14_streams;

import java.util.Arrays;
import java.util.Random;

public class RandInts {
    private static int[] rints = new Random(47)
            .ints(0, 1000)
            .limit(100)
            .toArray();

    public static void main(String[] args) {
        System.out.println(Arrays.toString(rints));
    }
}
