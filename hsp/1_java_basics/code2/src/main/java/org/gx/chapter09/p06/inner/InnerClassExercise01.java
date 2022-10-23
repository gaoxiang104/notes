package org.gx.chapter09.p06.inner;

public class InnerClassExercise01 {
    public static void show(Ioo01 a){
        a.cry();
    }

    public static void main(String[] args) {
        show(new Ioo01() {
            @Override
            public void cry() {
                System.out.println("hi");
            }
        });
    }
}

interface Ioo01{
    public void cry();
}
