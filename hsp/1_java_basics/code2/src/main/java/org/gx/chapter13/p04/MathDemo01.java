package org.gx.chapter13.p04;

public class MathDemo01 {
    public static void main(String[] args) {
        // 求绝对值
        System.out.println(Math.abs(-1)); // 1
        // 求幂，3的平方，返回double
        System.out.println(Math.pow(3, 2)); // 9.0
        // 向上取整，返回double
        System.out.println(Math.ceil(1.1)); // 2.0
        // 向下取整，返回double
        System.out.println(Math.floor(1.9)); // 1.0
        // round 四舍五入，返回long
        System.out.println(Math.round(1.4)); // 1
        System.out.println(Math.round(1.5)); // 2
        // sqrt 求开方
        System.out.println(Math.sqrt(2)); // 1.4142135623730951
        // random 求随机数
        System.out.println(Math.random());
        // max 求两个数的最大值
        System.out.println(Math.max(1, 2)); // 2
        // min 求两个数的最小值
        System.out.println(Math.min(1, 2)); // 1
    }
}
