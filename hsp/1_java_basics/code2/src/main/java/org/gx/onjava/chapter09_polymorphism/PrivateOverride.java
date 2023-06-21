package org.gx.onjava.chapter09_polymorphism;
// 试图重写一个private方法
public class PrivateOverride {
    private  void f(){
        System.out.println("private f()");
    }

    public static void main(String[] args) {
        PrivateOverride po = new Derived();
        po.f();
    }
}

class Derived extends PrivateOverride{
    public void f(){
        System.out.println("public f()");
    }
}

/* output
private f()
 */