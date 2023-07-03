package org.gx.onjava.chapter11_innerclass;
// 将一个类嵌入在方法中
public class Parcel5 {
    public Destination destination(String s) {
        final class PDestination implements Destination {
            private String label;

            public PDestination(String whereTo) {
                this.label = whereTo;
            }

            @Override
            public String readLabel() {
                return label;
            }
        }

        return new PDestination(s);
    }

    public static void main(String[] args) {
        Parcel5 p = new Parcel5();
        Destination d = p.destination("Tasmania");
    }
}
