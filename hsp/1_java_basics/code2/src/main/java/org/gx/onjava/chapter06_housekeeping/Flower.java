package org.gx.onjava.chapter06_housekeeping;

public class Flower {
    int petalCount = 0;
    String s = "initial value";

    Flower(int petals) {
        petalCount = petals;
        System.out.println("Constructor w/ int arg only, petalCount= " + petalCount);
    }

    Flower(String ss) {
        s = ss;
        System.out.println("Constructor w/ String arg only, s= " + s);
    }

    Flower(String s, int petals) {
        this(petals);
        // this(s); // 不能同时调用两个构造器
        this.s = s;

        System.out.println("String & int args");
    }

    Flower(){
        this("hi", 47);
        System.out.println("Zero-argument constructor");
    }

    void printPetalCount(){
        // this(11); // 不能用在非构造器里
        System.out.println("peatlCount = " + petalCount + ", s = " + s);
    }

    public static void main(String[] args) {
        Flower flower = new Flower();
        flower.printPetalCount();
    }
}
/* OUT
Constructor w/ int arg only, petalCount= 47
String & int args
Zero-argument constructor
peatlCount = 47, s = hi
 */