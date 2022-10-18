package org.gx.chapter09.p03.final_;

public class FinalDetail03 {
    public static void main(String[] args) {
        B b = new B();
        b.f1(); // 父类的final方法，子类虽然不能重写，但是可以使用
    }
}

class A {
    public final void f1() {
        System.out.println("A.f1()");
    }
}

class B extends A {
    // 父类方法是final的，子类不能重写
//    public final void f1(){
//        System.out.println("A.f1()");
//    }
}
