package pers.xgo.onjava.chapter04_operators;

public class Casting {
    public static void main(String[] args) {
        int i = 200;
        long lng = (long) i;
        lng = i; // 宽化，因此不需要强制转换类型
        long lng2 = (long) 200;
        lng2 = 200;
        // 一个窄化转型
        i = (int) lng2; // 需要强制类型转换
    }
}
