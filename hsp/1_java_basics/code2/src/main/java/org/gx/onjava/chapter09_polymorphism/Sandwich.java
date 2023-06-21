package org.gx.onjava.chapter09_polymorphism;
// 构造器调用顺序

class Meal { // 一餐
    Meal() {
        System.out.println("Meal()");
    }
}

class Bread {
    Bread() {
        System.out.println("Bread()");
    }
}

class Cheese { // 芝士
    Cheese() {
        System.out.println("Cheese()");
    }
}

class Lettuce { // 生菜
    Lettuce() {
        System.out.println("Lettuce()");
    }
}

class Lunch extends Meal { // 午餐
    Lunch() {
        System.out.println("Lunch()");
    }
}

class PortableLunch extends Lunch { // 便携式午餐
    PortableLunch() {
        System.out.println("PortableLunch()");
    }
}

public class Sandwich extends PortableLunch { // 三明治
    private Bread b = new Bread();
    private Cheese c = new Cheese();
    private Lettuce l = new Lettuce();

    public Sandwich() {
        System.out.println("Sandwich()");
    }

    public static void main(String[] args) {
        new Sandwich();
    }
}
/*
Meal()
Lunch()
PortableLunch()
Bread()
Cheese()
Lettuce()
Sandwich()
 */

