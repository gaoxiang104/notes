package pers.xgo.onjava.chapter04_operators;

public class Literals {
    public static void main(String[] args) {
        int i1 = 0x2f; // 十六进制（小写）
        System.out.println("i1: " + Integer.toBinaryString(i1));
        int i2 = 0x2F; // 十六进制（大写）
        System.out.println("i2: " + Integer.toBinaryString(i2));
        int i3 = 0177; // 八进制
        System.out.println("i3: " + Integer.toBinaryString(i3));
        char c = 0xffff; // char 类型大最大十六进制值
        System.out.println("c: " + Integer.toBinaryString(c));
        byte b = 0x7f; // byte 类型大最大十六进制值
        System.out.println("b: " + Integer.toBinaryString(b));
        short s = 0x7fff; // short 类型大最大十六进制值
        System.out.println("s: " + Integer.toBinaryString(s));
        long n1 = 200L; // long类型后缀
        long n2 = 200l; // long类型后缀（很容易让人困惑）
        long n3 = 200;
        byte blb = (byte) 0b00110101;
        System.out.println("blb: " + Integer.toBinaryString(blb));
        short bls = (short) 0b00110101;
        System.out.println("bls: " + Integer.toBinaryString(bls));
        int bli = 0b00110101;
        System.out.println("bli: " + Integer.toBinaryString(bli));
        long bll = (long) 0b00110101;
        System.out.println("bll: " + Long.toBinaryString(bll));
        float f1 = 1;
        float f2 = 1F;
        float f3 = 1f;
        double d1 = 1d;
        double d2 = 1D;
    }
}
