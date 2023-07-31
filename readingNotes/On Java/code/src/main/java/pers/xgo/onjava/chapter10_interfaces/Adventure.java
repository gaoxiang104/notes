package pers.xgo.onjava.chapter10_interfaces;

interface CanFight{ // 可以战斗
    void fight(); // 战斗
}

interface CanSwim { // 可以游泳
    void swim(); // 游泳
}

interface CanFly{ // 可以飞行
    void fly(); // 飞行
}

class ActionCharacter { // 动作角色
    public void fight(){} // 战斗
}

class Hero extends ActionCharacter implements CanFight,CanSwim,CanFly {
    @Override
    public void swim() { }
    @Override
    public void fly() { }
}

//冒险
public class Adventure {
    public static void t(CanFight x) { x.fight(); }
    public static void u(CanSwim x) { x.swim(); }
    public static void v(CanFly x) { x.fly(); }
    public static void w(ActionCharacter x) { x.fight(); }

    public static void main(String[] args) {
        Hero h = new Hero();
        t(h); // 当作一个CanFight
        u(h); // 当作一个CanSwim
        v(h); // 当作一个CanFly
        w(h); // 当作一个ActionCharacter
    }
}
