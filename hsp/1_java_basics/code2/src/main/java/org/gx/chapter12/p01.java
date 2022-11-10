package org.gx.chapter12;

public class p01 {
    public static void main(String[] args) {
        // 手动装箱
        int n1 = 100;
        Integer integer = new Integer(n1);
        Integer integer1 = Integer.valueOf(n1);
        // 手动拆箱
        int i = integer1.intValue();

        // jdk1.5之后
        // 自动装箱
        int n2 = 100;
        Integer integer2 = n2;
        // 自动拆箱
        int i2 = integer2;

        Integer.parseInt("0");
        Integer.valueOf("0");

    }
}
