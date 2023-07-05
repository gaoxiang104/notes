package org.gx.onjava.chapter11_innerclass;
// 对于具有类或抽象类，内部类可以产生 “多重实现继承” 的效果

class D {
}

abstract class E {
}

class Z extends D {
    E makeE() {
        return new E() {
        };
    }
}

public class MultiImplementation {
    static void takesD(D d) {
    }

    static void takesE(E e) {
    }

    public static void main(String[] args) {
        Z z = new Z();
        takesD(z);
        takesE(z.makeE());
    }
}
