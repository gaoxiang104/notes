package org.gx.chapter09.p06.inner;

public class AnonymousInnerClass {
}

class Outer01 {
    void m1() {

        new Ioo() {
            @Override
            public void cry() {

            }
        };

        // 这里的 "aa" 就相当于Father构造器中传值，
        new Father("aa") {
            @Override
            public void test() {
                super.test();
            }
        };
    }
}

interface Ioo {
    void cry();
}

class Father {
    private String name;

    public Father(String name) {
        this.name = name;
    }

    public void test() {
    }
}

class Son extends Father {
    public Son() {
        super("name");
    }
}