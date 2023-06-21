package org.gx.onjava.chapter09_polymorphism.music;

// 继承与向上转型
public class Music {
    // 并不关系类型，所以添加到系统的新类型仍然正常工作
    public static void tune(Instrument i) {
        i.play(Note.MIDDLE_C);
    }

    public static void tuneAll(Instrument[] e) {
        for (Instrument i : e) {
            tune(i);
        }
    }

    public static void main(String[] args) {
//        Wind flute = new Wind();
//        tune(flute); // 向上转型

        // 在数组填充时会向上转型：
        Instrument[] orchestra = {
                new Wind(),
                new Percussion(),
                new Stringed(),
                new Brass(),
                new Woodwind()
        };

        tuneAll(orchestra);
    }
}
