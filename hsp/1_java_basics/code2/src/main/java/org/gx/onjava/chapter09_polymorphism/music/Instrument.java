package org.gx.onjava.chapter09_polymorphism.music;

// 乐器
public class Instrument {
    public void play(Note n) {
        System.out.println("Instrument.play()");
    }

    String what() {
        return "Instrument";
    }

    void adjust(){ // 调试
        System.out.println("Adjusting Instrument");
    }
}
