package pers.xgo.onjava.chapter19_reflection;

/** 泛型类引用 */
public class GenericClassReferences {
    public static void main(String[] args) {
        Class intClass = int.class;
        intClass = double.class;
        Class<Integer> genericIntClass = int.class;
        genericIntClass = Integer.class; // 一样
        // genericIntClass = double.class; // 不合法
    }
}
