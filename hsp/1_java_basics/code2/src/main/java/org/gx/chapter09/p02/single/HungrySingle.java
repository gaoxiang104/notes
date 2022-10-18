package org.gx.chapter09.p02.single;

/**
 * 单例：饿汉模式
 */
public class HungrySingle {
    private static HungrySingle single = new HungrySingle();

    private HungrySingle() {
        System.out.println("HungrySingle constructor");
    }

    public static HungrySingle getInstance() {
        return single;
    }

    public static void main(String[] args) {
        HungrySingle s1 = HungrySingle.getInstance();
        HungrySingle s2 = HungrySingle.getInstance();
        System.out.println(s1 == s2);
    }
}
