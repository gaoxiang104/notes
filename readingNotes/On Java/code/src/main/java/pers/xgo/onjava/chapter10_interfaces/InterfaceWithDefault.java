package pers.xgo.onjava.chapter10_interfaces;

public interface InterfaceWithDefault {
    void firstMethod();

    void secondMethod();

    default void newMethod() {
        System.out.println("newMethod");
    }
}
