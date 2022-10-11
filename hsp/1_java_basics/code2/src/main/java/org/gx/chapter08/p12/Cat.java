package org.gx.chapter08.p12;

public class Cat extends Animal {
    public Cat() {
    }

    public Cat(String name) {
        super(name);
    }

    @Override
    public void cry() {
        System.out.println("Cat " + getName() + " cry()....");
    }
}
