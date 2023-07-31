package pers.xgo.onjava.chapter10_interfaces;
// {NewFeature} 从 JDK9 开始

interface Old {
    default void fd(){
        System.out.println("Old::fd()");
    }
    static void fs(){
        System.out.println("Old::fs()");
    }
    default void f(){
        fd();
    }
    static void g(){
        fs();
    }
}

class ImlOld implements Old {}

interface JDK9 {
    private void fd() { // 自动是 default
        System.out.println("JDK9::fd()");
    }
    private static void fs(){
        System.out.println("JDK9::fs()");
    }
    default void f(){
        fd();
    }
    static void g(){
        fs();
    }
}

class ImlJDK9 implements JDK9 {}

public class PrivateInterfaceMethods {
    public static void main(String[] args) {
        new ImlOld().f();
        Old.g();

        new ImlJDK9().f();
        JDK9.g();
    }
}
