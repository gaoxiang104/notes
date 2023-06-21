package org.gx.onjava.chapter09_polymorphism.music;

// Stringed对象是一种Instrument
// 因为它们有相同的接口
public class Stringed extends Instrument { // 弦乐
    @Override
    public void play(Note n) {
        System.out.println("Stringed.play() " + n);
    }

    @Override
    String what() {
        return "Stringed";
    }

    @Override
    void adjust() {
        System.out.println("Adjusting Stringed");
    }
}
