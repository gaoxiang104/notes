package org.gx.chapter09.p06.inner;

public class MemberInnerClass01 {
    public static void main(String[] args) {
        Outer02 outer = new Outer02();
        // 外部其他类，调用成员内部类的两种方式

        // 方式1 ： 外部类的对象.new 内部类()
        Outer02.Inner inner1 = outer.new Inner();
        // 方式2 ： 在外部类中，编写一个方法，可以返回 Inner 对象
        Outer02.Inner inner2 = outer.getInner();

    }
}

class Outer02 {
    private String name;
    private Integer age;

    class Inner {
        void m() {
            name = "aaa";
            age = 22;
            System.out.println();
        }
    }

    Inner getInner() {
        return new Inner();
    }
}
