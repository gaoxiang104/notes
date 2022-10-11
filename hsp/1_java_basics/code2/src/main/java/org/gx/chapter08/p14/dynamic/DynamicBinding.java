package org.gx.chapter08.p14.dynamic;

public class DynamicBinding {
    public static void main(String[] args) {
        A a = new B();
        System.out.println(a.sum()); // 30 ，sum() 方法中的 getI() 是运行时动态绑定 B类的方法
        System.out.println(a.sum1()); // 20 ， 没有动态绑定机制，哪里声明，哪里使用，sum1() 方法中 i 是 A 类中的属性
    }
}

class A {
    public int i = 10;

    public int sum() {
        return getI() + 10;
    }

    public int sum1() {
        return i + 10;
    }

    public int getI() {
        return i;
    }
}

class B extends A{
    public int i = 20;

//    public int sum() {
//        return getI() + 20;
//    }

//    public int sum1() {
//        return i + 10;
//    }

    public int getI() {
        return i;
    }
}