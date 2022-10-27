package org.gx.chapter10.p02;

@SuppressWarnings("all")
public class DepercatedDemo {
    public static void main(String[] args) {
        System.out.println(Aoo.name);
        Aoo.m1();
    }
}

class Aoo{
    @Deprecated
    public static String name = "";
    @Deprecated
    public static void m1(){}
}
