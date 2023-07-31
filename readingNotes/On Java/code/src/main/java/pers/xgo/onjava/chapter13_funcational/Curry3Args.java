package pers.xgo.onjava.chapter13_funcational;

import java.util.function.Function;

public class Curry3Args {
    public static void main(String[] args) {
        Function<String,
                Function<String,
                        Function<String,String >>> sum =
                a -> b -> c -> a + b + c;

        Function<String,
                Function<String, String>> h1 = sum.apply("Hi ");

        Function<String ,String> ho = h1.apply("Ho ");
        System.out.println(ho.apply("Hup"));
    }
}
