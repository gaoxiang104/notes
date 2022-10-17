package org.gx.chapter08.p19;

public class Homework07 {
    public static void main(String[] args) {
        new Demo().test();
        new Demo("Jon").test();
    }
}

class Text {
    String name = "Jack";

    public Text() {
        System.out.println("Text");
    }

    public Text(String name) {
        this.name = name;
    }
}

class Demo extends Text {
    String name = "Rose";

    public Demo() {
        System.out.println("Demo");
    }

    public Demo(String name){
        super(name);
    }

    public void test(){
        System.out.println(super.name);
        System.out.println(this.name);
    }
}
