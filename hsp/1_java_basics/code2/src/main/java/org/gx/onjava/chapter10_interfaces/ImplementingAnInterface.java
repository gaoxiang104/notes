package org.gx.onjava.chapter10_interfaces;

interface Concept { // 概念
    void idea1();

    void idea2();
}

public class ImplementingAnInterface implements Concept {
    @Override
    public void idea1() {
        System.out.println("idea1");
    }

    @Override
    public void idea2() {
        System.out.println("idea2");
    }
}
