package pers.xgo.onjava.chapter19_reflection.other;

import java.util.ArrayList;
import java.util.Map;

/**
 * 关于 Class 中 getCanonicalName() 方法，返回此 Class 对象所表示的实体的规范名称
 */
public class CanonicalNameDemo {
    public static void main(String[] args) {
        // 普通类
        System.out.println(String.format("ArrayList: %s", ArrayList.class.getCanonicalName()));
        // 内部类
        System.out.println(String.format("Map.Entry: %s", Map.Entry.class.getCanonicalName()));
        // 基本类型
        System.out.println(String.format("int: %s", int.class.getCanonicalName()));
        // 数组类型
        System.out.println(String.format("int[]: %s", int[].class.getCanonicalName()));
        System.out.println(String.format("String[]: %s", String[].class.getCanonicalName()));
        // 匿名类
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

            }
        };
        System.out.println(String.format("Anonymous class: %s", runnable.getClass().getCanonicalName()));
        // 局部类
        class LocalClass {}
        System.out.println(String.format("Local class: %s", LocalClass.class.getCanonicalName()));

    }
}
/* output:
ArrayList: java.util.ArrayList
Map.Entry: java.util.Map.Entry
int: int
int[]: int[]
String[]: java.lang.String[]
Anonymous class: null
Local class: null
 */