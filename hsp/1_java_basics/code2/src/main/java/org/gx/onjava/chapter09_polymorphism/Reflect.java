package org.gx.onjava.chapter09_polymorphism;

// 向下转型
class Useful {
    public void f() {
    }

    public void g() {
    }
}

class MoreUseful extends Useful {
    @Override
    public void f() {
        super.f();
    }

    @Override
    public void g() {
        super.g();
    }

    public void u() {
    }

    public void v() {
    }

    public void w() {
    }
}

public class Reflect {
    public static void main(String[] args) {
        Useful[] x = {
                new Useful(),
                new MoreUseful()
        };
        x[0].f();
        x[1].g();
//        x[1].u(); // 编译时错误：无法在 Useful 中发现方法
        ((MoreUseful)x[1]).u(); // 向下转型/反射
        ((MoreUseful)x[0]).u(); // 抛出异常
    }
}
