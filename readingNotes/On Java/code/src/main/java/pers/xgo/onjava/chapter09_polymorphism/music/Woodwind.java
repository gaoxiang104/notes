package pers.xgo.onjava.chapter09_polymorphism.music;

// Woodwind对象是一种Wind
// 因为它们有相同的接口
public class Woodwind extends Instrument { // 金属管乐器
    @Override
    public void play(Note n) {
        System.out.println("Woodwind.play() " + n);
    }

    @Override
    String what() {
        return "Woodwind";
    }
}
