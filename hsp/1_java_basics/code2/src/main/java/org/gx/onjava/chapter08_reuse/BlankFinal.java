package org.gx.onjava.chapter08_reuse;
// 空白final

class Poppet {
    private int i;

    Poppet(int i) {
        this.i = i;
    }
}

public class BlankFinal {
    private final int i = 0; // 初始化了的final
    private final int j; // 空白final
    private final Poppet p; // 空白final引用

    public BlankFinal() {
        j = 1; // 初始化空白 final;
        p = new Poppet(i); // 初始化空白 final引用
    }

    public BlankFinal(int x) {
        j = x; // 初始化空白 final;
        p = new Poppet(x); // 初始化空白 final引用
    }

    public static void main(String[] args) {
        new BlankFinal();
        new BlankFinal(47);
    }
}
