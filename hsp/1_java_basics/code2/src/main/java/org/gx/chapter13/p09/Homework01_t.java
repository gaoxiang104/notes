package org.gx.chapter13.p09;

public class Homework01_t {

    public static void main(String[] args) {
        String s = reverse("abcdefg", 1, 5);
        System.out.println(s);
    }

    public static String reverse(String str, int start, int end) {
        if (null == str) {
            throw new IllegalArgumentException("str 是空的");
        }
        if (start < 0 || start > str.length() - 1) {
            throw new IllegalArgumentException("start 错误");
        }
        if (end < 0 || end > str.length() - 1) {
            throw new IllegalArgumentException("end 错误");
        }
        char[] chars = str.toCharArray();
        for (int i = start, j = end; i < j; i++, j--) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return new String(chars);
    }
}
