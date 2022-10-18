package org.gx.chapter09.p02.single;

public class LazySingle {
    private static LazySingle single;

    private LazySingle() {
        System.out.println("LazySingle constructor");
    }

    public static LazySingle getInstance() {
        if (null == single) {
            single = new LazySingle();
        }
        return single;
    }

    public static void main(String[] args) {
        LazySingle s1 = LazySingle.getInstance();
        LazySingle s2 = LazySingle.getInstance();
        System.out.println(s1 == s1);
    }
}
