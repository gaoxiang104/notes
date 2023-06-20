package org.gx.onjava.chapter09_polymorphism.shape;

// 圆形
public class Circle extends Shape{
    @Override
    public void draw() {
        System.out.println("Circle.draw()");
    }

    @Override
    public void erase() {
        System.out.println("Circle.erase()");
    }
}
