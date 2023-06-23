package org.gx.onjava.chapter09_polymorphism;
// 协变返回类型

class Grain { // 粮食
    @Override
    public String toString() {
        return "Grain";
    }
}

class Wheat extends Grain { // 小麦
    @Override
    public String toString() {
        return "Wheat";
    }
}

class Mill { // 磨坊
    Grain process() { // 过程
        return new Grain();
    }
}

class WheatMill extends Mill { // 小麦磨坊
    @Override
    Wheat process() {
        return new Wheat();
    }
}

public class CovariantReturn {
    public static void main(String[] args) {
        Mill m = new Mill();
        Grain g = m.process();
        System.out.println(g);
        m = new WheatMill();
        g = m.process();
        System.out.println(g);
    }
}
/* OUTPUT
Grain
Wheat
 */