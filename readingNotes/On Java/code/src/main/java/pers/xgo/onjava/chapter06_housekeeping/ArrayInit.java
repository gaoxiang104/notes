package pers.xgo.onjava.chapter06_housekeeping;

import java.util.Arrays;

// 数组初始化
public class ArrayInit {
    public static void main(String[] args) {
        Integer[] a = {1,2,3,};
        Integer[] b = new Integer[]{1,2,3,4,};
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        //
        f();
    }

    static void f(String... args){
        System.out.println("f()");
    }

}
