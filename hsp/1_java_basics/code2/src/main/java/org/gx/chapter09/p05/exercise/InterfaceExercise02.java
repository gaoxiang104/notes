package org.gx.chapter09.p05.exercise;

public class InterfaceExercise02 {
    public static void main(String[] args) {
        new Coo1().showX();
    }
}

interface Aoo1 {
    int x = 0; // public static final int x = 0;
}

class Boo1 {
    int x = 1;
}

class Coo1 extends Boo1 implements Aoo1 {
    public void showX() {
//        System.out.println(x); // 错误，x不明确，Aoo1中有x，Boo1中也有x
        // 如果要使用x，需明确指出哪里的x
        System.out.println(super.x + "  " + Aoo1.x);
    }
}
