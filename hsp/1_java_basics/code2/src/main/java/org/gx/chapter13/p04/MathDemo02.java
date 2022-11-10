package org.gx.chapter13.p04;

public class MathDemo02 {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
        System.out.println(specifiedRangeRandom(2, 7));
        }
    }

    /**
     * 指定范围 随机
     *
     * @param a
     * @param b
     * @return
     */
    public static int specifiedRangeRandom(int a, int b) {
        return a + (int) (Math.random() * (b - a + 1));
    }
}
