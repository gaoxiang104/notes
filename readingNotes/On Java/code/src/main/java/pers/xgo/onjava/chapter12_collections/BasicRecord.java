package pers.xgo.onjava.chapter12_collections;
// {NewFeature} 从 JDK 16 开始

import java.util.Map;

record Employee(String name, int id) {
}

public class BasicRecord {
    public static void main(String[] args) {
        var bob = new Employee("Bob Dobbs", 11);
        var dot = new Employee("Dorothy Gale", 9);
        // bob.id = 12; // 错误
        // id 在 Employee 中的访问权限是 private
        System.out.println(bob.name()); // 访问器
        System.out.println(bob.id()); // 访问器
        System.out.println(bob); // toString()
        // Employee 可以用做 Map 中的键
        var map = Map.of(bob, "A", dot, "B");
        System.out.println(map);
    }
}
