package org.gx.chapter08.p12;

public class Dog extends Animal{

    public Dog() {
    }

    public Dog(String name) {
        super(name);
    }

    @Override
    public void cry() {
        System.out.println("Dog " + getName() + " cry()....");
    }
}
