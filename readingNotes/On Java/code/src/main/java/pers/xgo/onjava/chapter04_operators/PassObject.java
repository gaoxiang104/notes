package pers.xgo.onjava.chapter04_operators;

class Letter { // 信，函
    char c;
}

public class PassObject { // 传递对象
    static void f(Letter y) {
        y.c = 'z';
    }

    public static void main(String args[]) {
        Letter x = new Letter();
        x.c = 'a';
        System.out.println("1: x.c: " + x.c);
        f(x);
        System.out.println("2: x.c: " + x.c);
    }
}
