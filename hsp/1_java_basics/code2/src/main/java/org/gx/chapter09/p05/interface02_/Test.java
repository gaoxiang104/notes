package org.gx.chapter09.p05.interface02_;

import org.gx.chapter09.p05.interface_.Interface01;

public class Test {
    public static void main(String[] args) {
        Aoo aoo = new Aoo();
        aoo.f2();


    }
}

class Aoo implements Interface01{
    @Override
    public void f1() {

    }
}
