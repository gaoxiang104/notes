package org.gx.chapter13.p01;

public class StringDemo02 {
    String str = new String("abc");
    final char[] ch = {'j', 'a', 'v', 'a'};

    public void change(String str, char ch[]) {
        str = "java";
        ch[0] = 'g';
    }

    public static void main(String[] args) {
        StringDemo02 sd2 = new StringDemo02();
        sd2.change(sd2.str, sd2.ch);
        System.out.println(sd2.str);
        System.out.println(sd2.ch);
    }
}
