package pers.xgo.onjava.chapter04_operators;

public class StringOperators {
    public static void main(String[] args) {
        int x = 0, y = 1, z = 2;
        String s = "x, y, z ";
        System.out.println(s + x + y + z); // x, y, z 012
        // 将 x 转为字符串
        System.out.println(x + " " + z); // 0 2
        s += "(summed) = "; // 拼接操作
        System.out.println(s + (x + y + z));
        // Integer.toBinaryString() 的简化版：
        System.out.println("" + x);
    }
}
