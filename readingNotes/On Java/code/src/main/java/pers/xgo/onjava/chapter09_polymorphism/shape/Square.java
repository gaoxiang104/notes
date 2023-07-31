package pers.xgo.onjava.chapter09_polymorphism.shape;

// 正方形
public class Square extends Shape{
    @Override
    public void draw() {
        System.out.println("Square.draw()");
    }

    @Override
    public void erase() {
        System.out.println("Square.erase()");
    }
}
