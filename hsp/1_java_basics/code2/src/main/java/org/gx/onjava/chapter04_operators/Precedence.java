package org.gx.onjava.chapter04_operators;

public class Precedence { // 优先级
    public static void main(String[] args) {
        int x = 1, y = 2, z = 3;
        int a = x + y - 2 / 2 + z;
        int b = x + (y - 2) / (2 + z);
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}