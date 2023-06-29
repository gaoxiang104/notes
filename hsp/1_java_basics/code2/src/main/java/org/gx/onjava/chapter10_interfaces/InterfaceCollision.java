package org.gx.onjava.chapter10_interfaces;
// 接口命名冲突
interface I1 { void f(); }
interface I2 { int f(int i); }
interface I3 { int f(); }
class C { public int f() { return 1;} }

class C2 implements I1, I2 {
    @Override public void f() { }
    @Override public int f(int i) { return 1; } // 重载
}

class C3 extends C implements I2 {
    @Override public int f(int i) { return 1; } // 重载
}

class C4 extends C implements I3 {
    // 完全相同，没有问题
    @Override public int f() { return 1; }
}

// 方法只有返回类型不同
//class C5 extends C implements I1 {}
// interface I4 extends I1, I3 {}

public class InterfaceCollision {
}
