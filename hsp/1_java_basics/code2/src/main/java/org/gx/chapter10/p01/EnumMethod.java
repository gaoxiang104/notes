package org.gx.chapter10.p01;

public class EnumMethod {
    public static void main(String[] args) {
        Num z = Num.ZERO;
        // 1，输出枚举对象的名称
        System.out.println(z.name());
        // 2，输出该枚举对象的序号
        System.out.println(z.ordinal());
        // 3，从反编译可以看出 values 方法，返回 Num[]
        // 含有定义的所有枚举对象
        System.out.println("循环输出 Num 的所有枚举对象：");
        for (Num value : Num.values()) {
            System.out.println(value);
        }
        System.out.println("循环结束");
        // 4，valueOf：将字符串转换成枚举对象，要求字符串必须为已有的常量名，否则报异常
        Num one = Num.valueOf("ONE");
        System.out.println(one);
//        Num one = Num.valueOf("ONE1"); // No enum constant org.gx.chapter10.p01.Num.ONE1
        // 5, 比较两个枚举常量，比较的就是位置号！
        System.out.println(Num.TWO.compareTo(Num.FIVE)); // Num.TWO.ordinal() - Num.FIVE.ordinal();
    }
}

enum Num {
    ZERO,
    ONE,
    TWO,
    THREE,
    FOUR,
    FIVE;
}