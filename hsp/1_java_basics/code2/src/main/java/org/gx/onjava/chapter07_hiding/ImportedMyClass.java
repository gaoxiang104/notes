package org.gx.onjava.chapter07_hiding;

import org.gx.onjava.chapter07_hiding.mypackage.MyClass;

public class ImportedMyClass {
    public static void main(String[] args) {
        var m1 = new org.gx.onjava.chapter07_hiding.mypackage.MyClass(); // 完全限定的名称
        var m2 = new MyClass();
    }
}
