package org.gx.onjava.chapter11_innerclass;

public class Parcel2 {
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

    public Destination to(String  s){
        return new Destination(s);
    }

    public Contents contents(){
        return new Contents();
    }

    // 在 Parcel1 内，使用内部类看上去就和使用任何其他类一样
    public void ship(String dest){ // 运输
        Contents c = new Contents();
        Destination d = new Destination(dest);
        System.out.printf(d.readLabel());
    }

    public static void main(String[] args) {
        Parcel2 p = new Parcel2();
        p.ship("Tasmania");
        Parcel2 q = new Parcel2();
        // 定义指向内部类的引用
        Parcel2.Contents c = q.contents();
        Parcel2.Destination d = q.to("Borneo");
    }
}
/* OUTPUT:
Tasmania
 */