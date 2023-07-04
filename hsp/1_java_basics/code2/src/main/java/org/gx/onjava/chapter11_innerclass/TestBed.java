package org.gx.onjava.chapter11_innerclass;
// 将测试代码放到一个嵌套类中
public class TestBed {
    public void f() {
        System.out.printf("f()");
    }

    public static class Tester {
        public static void main(String[] args) {
            TestBed t = new TestBed();
            t.f();
        }
    }
}
