package org.gx.onjava.chapter11_innerclass;

public class Parcel1 { // 包裹
    class Contents { // 内容
        private int i = 11;

        public int value() {
            return i;
        }
    }

    class Destination { // 目的地
        private String label;

        public Destination(String whereTo) {
            this.label = whereTo;
        }

        String readLabel() {
            return label;
        }
    }

    // 在 Parcel1 内，使用内部类看上去就和使用任何其他类一样
    public void ship(String dest){ // 运输
        Contents c = new Contents();
        Destination d = new Destination(dest);
        System.out.printf(d.readLabel());
    }

    public static void main(String[] args) {
        Parcel1 p = new Parcel1();
        p.ship("Tasmania");
    }
}
/* OUTPUT:
Tasmania
 */