package org.gx.chapter10.p03;

public class HomeWork04 {
    public static void main(String[] args) {
        new Cellphone().testWork(new Calculator() {
            @Override
            public int work(int a, int b) {
                return a + b;
            }
        }, 1, 2);
    }
}

interface Calculator {
    int work(int a, int b);
}

class Cellphone {
    public void testWork(Calculator calculator, int a, int b) {
        System.out.println("计算结果：" + calculator.work(a, b));
    }
}
