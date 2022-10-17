package org.gx.chapter09.p01;

public class CodeBlockDetail02 {
    public static void main(String[] args) {
        new B();
        // 输出
        // A getN() 被调用。。。
        // A 静态代码块被调用。。。
        // B getS() 被调用。。。。
        // B 静态代码块 被调用。。。
        // A getN() 被调用。。。
        // A 普通代码块被调用
        // A 构造器被调用。。。
        // B getS() 被调用。。。。
        // B 普通代码块被调用
        // B 的构造器被调用
    }
}

class A {
    private static int n1= getN();

    public static int getN(){
        System.out.println("A getN() 被调用。。。");
        return 100;
    }

    static {
        System.out.println("A 静态代码块被调用。。。");
    }

    private int n2 = getN();

    {
        System.out.println("A 普通代码块被调用");
    }

    public A() {
        System.out.println("A 构造器被调用。。。");
    }
}

class B extends A{
    private static String s1 = getS();

    static {
        System.out.println("B 静态代码块 被调用。。。");
    }

    private String s2 = getS();

    {
        System.out.println("B 普通代码块被调用");
    }

    public B() {
        System.out.println("B 的构造器被调用");
    }

    public static String getS(){
        System.out.println("B getS() 被调用。。。。");
        return "S";
    }

}
