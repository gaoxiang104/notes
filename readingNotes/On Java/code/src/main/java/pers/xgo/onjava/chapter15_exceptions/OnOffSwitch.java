package pers.xgo.onjava.chapter15_exceptions;

// 开关类
class Switch {
    private boolean state = false;

    public boolean read() {
        return state;
    }

    public void on() {
        state = true;
        System.out.println(this);
    }

    public void off() {
        state = false;
        System.out.println(this);
    }

    @Override
    public String toString() {
        return state ? "on" : "off";
    }
}

// 开关异常1
class OnOffException1 extends Exception{}
// 开关异常2
class OnOffException2 extends Exception{}

public class OnOffSwitch {
    private static Switch sw = new Switch();
    public static void f() throws OnOffException1,OnOffException2 {}

    public static void main(String[] args) {
        try {
            sw.on();
            // 可能会抛出异常的代码...
            f();
            sw.off();
        } catch (OnOffException1 e) {
            System.out.println("OnOffException1");
            sw.off();
        } catch (OnOffException2 e) {
            System.out.println("OnOffException2");
            sw.off();
        }
    }
}
