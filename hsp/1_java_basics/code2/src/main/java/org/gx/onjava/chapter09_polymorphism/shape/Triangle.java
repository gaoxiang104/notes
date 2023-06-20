package org.gx.onjava.chapter09_polymorphism.shape;

// 正方形
public class Triangle extends Shape{
    @Override
    public void draw() {
        System.out.println("Triangle.draw()");
    }

    @Override
    public void erase() {
        System.out.println("Triangle.erase()");
    }
}
