package pers.xgo.onjava.chapter10_interfaces;
// 通过继承来扩展接口

interface Monster { // 怪物
    void menace(); // 威胁
}
interface DangerousMonster extends  Monster{ // 危险的怪物
    void destroy(); // 摧毁
}

interface Lethal{ // 致命的
    void kill();
}

class DragonZilla implements DangerousMonster { // Zilla龙
    @Override public void menace() {}
    @Override public void destroy() {}
}

interface Vampire extends DangerousMonster, Lethal { // 吸血鬼
    void drinkBlood(); // 饮血
}

class VeryBadVampire implements Vampire { // 非常坏的吸血鬼
    @Override public void menace() { }
    @Override public void destroy() { }
    @Override public void kill() { }
    @Override public void drinkBlood() { }
}

public class HorrorShow { // 恐怖秀
    static void u(Monster b) { b.menace(); }
    static void v(DangerousMonster d) {
        d.menace();
        d.destroy();
    }
    static void w(Lethal l) { l.kill(); }

    public static void main(String[] args) {
        DangerousMonster barney = new DragonZilla();
        u(barney);
        v(barney);
        Vampire vlad = new VeryBadVampire();
        u(vlad);
        v(vlad);
        w(vlad);
    }
}
