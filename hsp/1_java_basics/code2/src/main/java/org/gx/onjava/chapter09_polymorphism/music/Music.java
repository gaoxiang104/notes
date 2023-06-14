package org.gx.onjava.chapter09_polymorphism.music;
// 继承与向上转型
public class Music {
    public static void tune(Instrument i){
        i.play(Note.MIDDLE_C);
    }

    public static void main(String[] args) {
        Wind flute = new Wind();
        tune(flute); // 向上转型
    }
}
