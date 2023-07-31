package pers.xgo.onjava.chapter09_polymorphism.music;

// Brass对象是一种Wind
// 因为它们有相同的接口
public class Brass extends Instrument { // 金属管乐器
    @Override
    public void play(Note n) {
        System.out.println("Brass.play() " + n);
    }

    @Override
    String what() {
        return "Brass";
    }


}
