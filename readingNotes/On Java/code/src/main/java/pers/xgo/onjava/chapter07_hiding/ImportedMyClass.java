package pers.xgo.onjava.chapter07_hiding;

import pers.xgo.onjava.chapter07_hiding.mypackage.MyClass;

public class ImportedMyClass {
    public static void main(String[] args) {
        var m1 = new pers.xgo.onjava.chapter07_hiding.mypackage.MyClass(); // 完全限定的名称
        var m2 = new MyClass();
    }
}
