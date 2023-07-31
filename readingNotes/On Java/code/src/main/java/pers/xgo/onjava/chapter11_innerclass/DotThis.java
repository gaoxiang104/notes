package pers.xgo.onjava.chapter11_innerclass;

// 访问外部类对象
public class DotThis {
    void f() {
        System.out.println("DotThis.f()");
    }

    public class Inner {
        public DotThis outer() {
            return DotThis.this;
            // 如果直接写 “this” ，引用的会是 Inner 的 “this”
        }

    }

    public Inner inner() {
        return new Inner();
    }

    public static void main(String[] args) {
        DotThis dt = new DotThis();
        Inner dti = dt.inner();
        dti.outer().f();
    }

}
