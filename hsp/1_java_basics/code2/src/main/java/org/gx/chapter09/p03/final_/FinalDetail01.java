package org.gx.chapter09.p03.final_;

public class FinalDetail01 {
    private final int i1 = 1; // 1.定义时赋值
    private final int i2;
    private final int i3;

    {
        i2 = 2; // 2.代码块中赋值
    }

    public FinalDetail01(int i3) {
        this.i3 = i3;   // 3.构造器中赋值
    }
}
