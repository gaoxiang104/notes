package org.gx.chapter13.p07;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalDemo01 {
    public static void main(String[] args) {
        BigDecimal b1 = new BigDecimal("3.1415926");
        BigDecimal b2 = new BigDecimal("3");
        // 加
        System.out.println(b1.add(b2));
        // 减
        System.out.println(b1.subtract(b2));
        // 乘
        System.out.println(b1.multiply(b2));
        // 除，有可能除不尽，会报异常，所有有必要设置一下 精度
        System.out.println(b1.divide(b2, 2, RoundingMode.HALF_UP));
        // 指定精度，保留两位，四舍五入
        System.out.println(b1.divide(b2).setScale(2, RoundingMode.HALF_UP));
    }
}
