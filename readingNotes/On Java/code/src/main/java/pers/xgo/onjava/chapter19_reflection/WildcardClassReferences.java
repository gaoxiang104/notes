package pers.xgo.onjava.chapter19_reflection;

/** 通配符类引用 */
public class WildcardClassReferences {
    public static void main(String[] args) {
        Class<?> intClass = int.class;
        intClass = double.class;
    }
}
