package org.gx.chapter09.p06.inner;

/**
 * 演示局部内部类
 */
public class InnerClass01 {
    public static void main(String[] args) {
        new Outer().f2();
    }
}

class Outer {
    int i = 1;

    void f1() {
        System.out.println("Outer.f1()");
    }

    void f2() {
        System.out.println("Outer.f2() : i=" + i);
        class Inner {
            int i = 2;

            void innerF1() {
                f1();
                System.out.println("Inner.innerF1() : i=" + i);
                // 如果外部类和局部内部类的成员重名时，默认遵循就近原则，如果想访问外部类的成员，则可以使用（外部类名.this.成员）去访问
                System.out.println("Inner.innerF1() : Outer.i=" + Outer.this.i);
            }
        }

        Inner inner = new Inner();
        inner.innerF1();
    }
}
