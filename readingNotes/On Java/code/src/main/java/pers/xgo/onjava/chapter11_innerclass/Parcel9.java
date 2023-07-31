package pers.xgo.onjava.chapter11_innerclass;

public class Parcel9 {
    // 要在匿名内部类中使用，
    // 参数必须是最终不变的，或者“实际上的最终变量”
    public Destination destination(String dest) {
        return new Destination() {
            @Override
            public String readLabel() {
                return dest;
            }
        };
    }

    public static void main(String[] args) {
        Parcel9 p = new Parcel9();
        Destination d = p.destination("Tasmania");
    }
}
