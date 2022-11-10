package org.gx.chapter13.p09;

public class Homework04 {
    public static void main(String[] args) {
        String str = "AAAbbb123@";
        int u = 0;
        int l = 0;
        int n = 0;
        int o = 0;

        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (c >= 'A' && c <= 'Z') {
                u++;
            } else if (c >= 'a' && c <= 'z') {
                l++;
            } else if (c >= '0' && c <= '9') {
                n++;
            } else {
                o++;
            }
        }
        System.out.println(str + "中有：大写字母" + u + "个，小写字母" + u + "个，数字" + n + "个，其他字符" + o + "个。");
    }

}
