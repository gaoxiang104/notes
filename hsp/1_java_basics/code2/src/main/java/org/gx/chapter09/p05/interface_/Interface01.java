package org.gx.chapter09.p05.interface_;

public interface Interface01 {
    // 默认方法
    default void f2() {
        System.out.println("f2()");
    }

    // 静态方法
    static void f3() {
        System.out.println("f3()");
    }

    void f1();
}
