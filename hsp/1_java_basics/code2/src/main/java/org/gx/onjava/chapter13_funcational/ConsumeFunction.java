package org.gx.onjava.chapter13_funcational;

import java.util.function.Function;

class One {}
class Two {}

public class ConsumeFunction {
    static Two consume(Function<One, Two> oneTwo) {
        return oneTwo.apply(new One());
    }

    public static void main(String[] args) {
        Two two = consume(one -> new Two());
    }
}
