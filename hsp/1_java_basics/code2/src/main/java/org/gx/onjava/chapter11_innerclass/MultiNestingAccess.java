package org.gx.onjava.chapter11_innerclass;

class MNA {
    private void f() {
    }

    class A {
        private void g() {

        }

        public class B {
            void h() {
                g();
                f();
            }
        }
    }
}

// 被嵌套的类可以访问各层外部类中的成员
public class MultiNestingAccess {
    public static void main(String[] args) {
        MNA mna = new MNA();
        MNA.A mnaa = mna.new A();
        MNA.A.B mnaab = mnaa.new B();
        mnaab.h();
    }
}
