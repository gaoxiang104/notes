package org.gx.chapter09.p06.inner;

public class MemberInnerClass02 {
    public static void main(String[] args) {
        Outer03 outer03 = new Outer03();
        outer03.m2();

        // 外部其他类，使用静态内部类
        Outer03.Inner inner = new Outer03.Inner();
    }
}

class Outer03 {
    static String str = "abc";

    void m1() {
        Inner.m1();
    }

    void m2() {
        System.out.println("Outer03.m2()");
        Inner inner = new Inner();
        inner.m2();
    }

    static class Inner {
        static String str = "123";

        static void m1() {
            System.out.println("m1()");

            System.out.println(str);
            System.out.println(Outer03.str);
        }

        void m2() {
            System.out.println("Inner.m2()");
        }
    }
}
