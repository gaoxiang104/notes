package pers.xgo.onjava.chapter19_reflection.pets;

public class Cat extends Pet{
    public Cat() {
    }

    public Cat(String name) {
        super(name);
    }

    public static void main(String[] args) {
        new Cat();
    }
}
