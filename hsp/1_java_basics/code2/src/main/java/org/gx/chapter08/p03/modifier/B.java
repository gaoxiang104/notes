package org.gx.chapter08.p03.modifier;

public class B {
    public void say() {
        A a = new A();
        // 在同一个包下，可以访问 public , protected 和 默认的， 不能访问  private
        System.out.println("a.n1=" + a.n1);
        System.out.println("a.n2=" + a.n2);
        System.out.println("a.n3=" + a.n3);
        // System.out.println("a.n4=" + a.n4); // 'n4' has private access
    }

    protected class C {

    }
}
