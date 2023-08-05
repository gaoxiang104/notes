package pers.xgo.onjava.chapter14_streams;

import pers.xgo.onjava.chapter10_interfaces.Operation;

import java.util.Arrays;

public class MetalWork2 {
    public static void main(String[] args) {
        Arrays.stream(new Operation[]{
                () -> Operation.show("Heat"),
                () -> Operation.show("Hammer"),
                () -> Operation.show("Twist"),
                () -> Operation.show("Anneal"),
        }).forEach(Operation::execute);
    }
}
