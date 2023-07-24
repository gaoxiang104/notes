package org.gx.onjava.chapter13_funcational;

interface Strategy { // 策略
    String approach(String msg); // 方法
}

class Soft implements Strategy { // 柔和的策略
    @Override
    public String approach(String msg) {
        return msg.toLowerCase() + "?";
    }
}

class Unrelated { // 不相关的
    static String twice(String msg) { // 两次
        return msg + " " + msg;
    }
}

public class Strategize { // 制定战略
    Strategy strategy; // 策略
    String msg;

    public Strategize(String msg) {
        strategy = new Soft(); // [1]
        this.msg = msg;
    }

    void communicate() { // 交流
        System.out.println(strategy.approach(msg));
    }

    void changeStrategy(Strategy strategy) { // 改变策略
        this.strategy = strategy;
    }

    public static void main(String[] args) {
        Strategy[] strategies = {
                new Strategy() { // [2]
                    @Override
                    public String approach(String msg) {
                        return msg.toUpperCase() + "!";
                    }
                },
                msg -> msg.substring(0, 5), // [3]
                Unrelated::twice // [4]
        };
        Strategize s = new Strategize("Hello there");
        s.communicate();
        for (Strategy newStrategy : strategies) {
            s.changeStrategy(newStrategy);
            s.communicate();
        }
    }
}
/* OUTPUT:
hello there?
HELLO THERE!
Hello
Hello there Hello there
 */