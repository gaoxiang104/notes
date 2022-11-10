package org.gx.chapter13.p08;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatterDemo01 {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter stf = DateTimeFormatter.ofPattern("yyyy年MM月dd日 hh时mm分ss秒");
        System.out.println(stf.format(now));
    }
}
