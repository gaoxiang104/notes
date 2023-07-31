package pers.xgo.onjava.chapter04_operators;

public class AutoInc { // 自动增长
    public static void main(String args[]) {
        int i = 1;
        System.out.println("i: " + i); // i: 1
        System.out.println("++i: " + ++i); // 前缀递增 ++i: 2
        System.out.println("i++: " + i++); // 后缀递增 i++: 2
        System.out.println("i: " + i); // i: 3
        System.out.println("--i: " + --i); // 前缀递减 --i: 2
        System.out.println("i--: " + i--); // 后缀递减 i--: 2
        System.out.println("i: " + i); // i: 1
    }
}
