package org.gx.onjava.chapter05_control;

// 逗号操作符
public class CommaOperator {
    public static void main(String[] args) {
        for (int i = 1, j = i + 10; i < 5; i++, j = i * 2) {
            System.out.println("i = " + i + ", j = " + j);
        }
    }
}

/* output
i = 1, j = 11
i = 2, j = 4
i = 3, j = 6
i = 4, j = 8
 */
