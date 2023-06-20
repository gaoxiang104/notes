package org.gx.onjava.chapter09_polymorphism.shape;

import java.util.Random;

// 一个随机产生形状的工厂
public class RandomShapes {
    private Random random = new Random(47);

    public Shape get() {
        switch (random.nextInt(3)) {
            default:
            case 0:
                return new Circle();
            case 1:
                return new Square();
            case 2:
                return new Triangle();
        }
    }

    public Shape[] array(int size) {
        Shape[] shapes = new Shape[size];
        for (int i = 0; i < shapes.length; i++) {
            shapes[i] = get();
        }
        return shapes;
    }
}
