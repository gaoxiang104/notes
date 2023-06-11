package org.gx.onjava.chapter08_reuse;
// 继承时调用构造器

class Art { // 艺术
    Art() {
        System.out.println("Art constructor");
    }
}

class Drawing extends Art { // 绘画
    Drawing() {
        System.out.println("Drawing constructor");
    }
}

public class Cartoon extends Drawing { // 卡通
    Cartoon() {
        System.out.println("Cartoon constructor");
    }

    public static void main(String[] args) {
        Cartoon x = new Cartoon();
    }
}
/* OUTPUT :
Art constructor
Drawing constructor
Cartoon constructor
 */