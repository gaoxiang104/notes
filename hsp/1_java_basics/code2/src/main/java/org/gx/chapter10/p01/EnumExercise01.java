package org.gx.chapter10.p01;

public class EnumExercise01 {
    public static void main(String[] args) {
        System.out.println("===所有星期的信息如下===");
        for (Week value : Week.values()) {
            System.out.println(value);
        }
    }
}

enum Week {
    MONDAY("星期一"),
    TUESDAY("星期二"),
    WEDNESDAY("星期三"),
    THURSDAY("星期四"),
    FRIDAY("星期五"),
    SATURDAY("星期六"),
    SUNDAY("星期日");
    private String name;

    Week(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}