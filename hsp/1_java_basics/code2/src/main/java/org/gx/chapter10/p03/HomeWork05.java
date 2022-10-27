package org.gx.chapter10.p03;

public class HomeWork05 {
    public static void main(String[] args) {
        new A("aa").m1();
    }
}

/*
  1. 编写一个类A，在类中定义局部内部类B，B中有一个私有常量name，有一个方法show()打印常量name。进行测试
  2. 进阶：A中也定义一个私有的变量name，在show方法中打印测试；
 */

class A {
    private String name;

    public A(String name) {
        this.name = name;
    }

    void m1() {
        class B {
            private String name;

            public B(String name) {
                this.name = name;
            }

            public void show() {
                System.out.println("B -> name:" + name);
                System.out.println("A -> name:" + A.this.name);
            }
        }

        new B("bb").show();
    }
}
