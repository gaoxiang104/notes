package org.gx.onjava.charpter12_collections;
// 简单集合类都使用（忽略编译器告警）

import org.gx.App;

import java.util.ArrayList;

class Apple{
    private static long counter;
    private final long id = counter++;
    public long id() {return  id;}
}

class Orange{}
public class ApplesAndOrangesWithoutGenerics {
//    @SuppressWarnings("unchecked")
//    public static void main(String[] args) {
//        ArrayList apples = new ArrayList();
//        for (int i = 0; i < 3; i++) {
//            apples.add(new Apple());
//        }
//        // 向 apples 中加入一个 Orange 也不会出问题：
//        apples.add(new Orange());
//        for (Object apple : apples){
//            ((Apple) apple).id();
//            // Orange 只有在运行时才会被检测出来
//        }
//    }

    public static void main(String[] args) {
        ArrayList<Apple> apples = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            apples.add(new Apple());
        }
        // 编译时错误
        // apples.add(new Orange());
        for (Apple apple : apples){
            System.out.println(apple.id());
        }
    }
}
