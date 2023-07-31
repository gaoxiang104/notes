package pers.xgo.onjava.chapter09_polymorphism.shape;

// 图形
public class Shape {
    public void draw() { // 绘制
    }

    public void erase() { // 擦除
    }

    public static void main(String[] args) {
        RandomShapes gen = new RandomShapes();
        // 执行多态方法调用
        for (Shape shape : gen.array(9)) {
            shape.draw();
        }
    }
}
