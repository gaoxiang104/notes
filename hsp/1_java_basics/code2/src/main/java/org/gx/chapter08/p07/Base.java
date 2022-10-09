package org.gx.chapter08.p07;

public class Base {
    private String str;

    public Base() {
        System.out.println("Base() .......");
    }

    public Base(String str) {
        System.out.println("Base(String str) .......");
        this.str = str;
    }
}
