package pers.xgo.onjava.chapter11_innerclass;

public class Parcel3 {
    class Contents {
        private int i = 11;

        private int value() {
            return i;
        }
    }

    class Destination {
        private String label;

        Destination(String whereTo) {
            label = whereTo;
        }

        String readLabel() {
            return label;
        }
    }

    public static void main(String[] args) {
        Parcel3 p = new Parcel3();
        // 必须使用外部类的实例
        // 来创建内部类的实例
        Contents c = p.new Contents();
        Destination d = p.new Destination("Tasmania");
    }
}
