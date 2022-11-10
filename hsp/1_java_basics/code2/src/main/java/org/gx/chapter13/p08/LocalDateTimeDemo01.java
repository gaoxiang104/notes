package org.gx.chapter13.p08;

import java.time.LocalDateTime;

public class LocalDateTimeDemo01 {
    public static void main(String[] args) {
        LocalDateTime l = LocalDateTime.now();
        System.out.println(l);
        System.out.println("年：" + l.getYear());
        System.out.println("月：" + l.getMonth());
        System.out.println("月：" + l.getMonthValue());
        System.out.println("日：" + l.getDayOfMonth());
        System.out.println("时：" + l.getHour());
        System.out.println("分：" + l.getMinute());
        System.out.println("秒：" + l.getSecond());

        l.plusYears(-2);
        System.out.println("l年 - 2：" + l.getYear());
        System.out.println("l.plusYears(-2)：" + l.plusYears(-2).getYear());
    }
}
