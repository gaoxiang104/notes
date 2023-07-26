package org.gx.onjava.chapter13_funcational;

class Go {
    static void go() {
        System.out.println("Go::go()");
    }
}

public class RunnableMethodReference {
    public static void main(String[] args) {
        new Thread(new Runnable() { // 匿名内部类
            @Override
            public void run() {
                System.out.println("Anonymous");
            }
        }).start();

        new Thread(() -> System.out.println("lambda"))
                .start();

        new Thread(Go::go).start();
    }
}
