package org.gx.chapter09.p03.final_;

public class FinalDetail02 {
    private static final int I_1 = 1; // 声明时赋值
    private static final int I_2;

    static {
        I_2 = 2; // 静态代码块中赋值
    }
}
