package pers.xgo.onjava.chapter11_innerclass.mui;
// 一个类可以以两种方式实现多个接口
interface A {
}

interface B {
}

class X implements A, B {
}

class Y implements A {
    B makeB() {
        return new B() {
        };
    }
}

public class MultiInterfaces {
    static void taskA(A a) {
    }

    static void taskB(B b) {
    }

    public static void main(String[] args) {
        X x = new X();
        Y y = new Y();
        taskA(x);
        taskB(x);
        taskA(y);
        taskB(y.makeB());
    }
}
