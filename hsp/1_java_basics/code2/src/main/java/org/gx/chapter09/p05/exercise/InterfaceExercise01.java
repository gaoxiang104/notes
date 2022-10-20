package org.gx.chapter09.p05.exercise;

public class InterfaceExercise01 {
    public static void main(String[] args) {
        Boo boo = new Boo();
        System.out.println(boo.a); // 正确
        System.out.println(Boo.a); // 正确
        System.out.println(Aoo.a); // 正确
    }
}

interface Aoo {
    int a = 23; // public static final int a = 23;
}

class Boo implements Aoo {
}