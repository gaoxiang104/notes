package org.gx.chapter13.p08;

import java.util.Calendar;

public class CalenderDemo {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        System.out.println("年：" + c.get(Calendar.YEAR));
        System.out.println("月：" + (c.get(Calendar.MONTH) + 1)); // 月份是从0开始的
        System.out.println("日：" + c.get(Calendar.DAY_OF_MONTH));
        System.out.println("上午/下午：" + c.get(Calendar.AM_PM));
        System.out.println("时：" + c.get(Calendar.HOUR_OF_DAY));
        System.out.println("分：" + c.get(Calendar.MINUTE));
        System.out.println("秒：" + c.get(Calendar.SECOND));

    }
}
