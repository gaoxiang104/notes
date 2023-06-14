package org.gx.onjava.chapter09_polymorphism.music;

// Wind对象时一种Instrument
// 因为它们有相同的接口
public class Wind extends Instrument { // 管乐器
    @Override
    public void play(Note n) {
        System.out.println("Wind.play() " + n);
    }
}
