package pers.xgo.onjava.chapter14_streams;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class RandInts {
    private static int[] rints = new Random(47)
            .ints(0, 1000)
            .limit(100)
            .toArray();

    public static IntStream rands(){
        return Arrays.stream(rints);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(rints));
    }
}
