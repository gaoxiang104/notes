package org.gx.onjava.chapter09_polymorphism.music;

// Percussion对象是一种Instrument
// 因为它们有相同的接口
public class Percussion extends Instrument { // 打击乐器
    @Override
    public void play(Note n) {
        System.out.println("Percussion.play() " + n);
    }

    @Override
    String what() {
        return "Percussion";
    }

    @Override
    void adjust() {
        System.out.println("Adjusting Percussion");
    }
}
