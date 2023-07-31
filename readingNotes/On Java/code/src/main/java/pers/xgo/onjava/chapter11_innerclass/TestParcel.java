package pers.xgo.onjava.chapter11_innerclass;

public class TestParcel {
    public static void main(String[] args) {
        Parcel4 p = new Parcel4();
        Contents c = p.contents();
        Destination d = p.destination("Tasmania");
        // 非法 —— 不能访问 private 类
        // Parcel4.PContents pc = p.new PContents();
    }
}
