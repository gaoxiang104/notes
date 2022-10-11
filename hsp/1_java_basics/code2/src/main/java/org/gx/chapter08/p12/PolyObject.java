package org.gx.chapter08.p12;

public class PolyObject {
    public static void main(String[] args) {
        // 向上转型
        Animal dog = new Dog("Dd"); // 编译类型：Animal, 运行类型：Dog
        dog.cry();
        Animal cat = new Cat("Tom");    // 编译类型：Animal, 运行类型：Cat
        cat.cry();

        // 向下转型
        Dog d = (Dog) new Animal();

        Dog dd = (Dog) cat;
    }
}


