package org.gx.chapter09.p06.inner;

public class InnerClassExercise02 {
    public static void main(String[] args) {
        Cellphone cellphone = new Cellphone();
        cellphone.alarmclock(new Bell() { // 起床铃
            @Override
            public void ring() {
                System.out.println(this.getClass());
                System.out.println("起床了！！！");
            }
        });
        cellphone.alarmclock(new Bell() {
            @Override
            public void ring() {
                System.out.println(this.getClass());
                System.out.println("上课了！！！");
            }
        });
    }
}

/** 闹铃 */
interface Bell {
    void ring(); // 响了
}

class Cellphone {
    public void alarmclock(Bell bell) {
        bell.ring();
    }
}