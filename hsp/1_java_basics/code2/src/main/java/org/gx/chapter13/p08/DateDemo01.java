package org.gx.chapter13.p08;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo01 {
    public static void main(String[] args) {
        Date d1 = new Date();
        System.out.println(d1);
        Date d2 = new Date(9234567);
        System.out.println(d2);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(simpleDateFormat.format(d1));
        System.out.println(simpleDateFormat.format(d2));

        String dateStr = "2022-11-11 15:30:00";
        try {
            Date d3 = simpleDateFormat.parse(dateStr);
            System.out.println(d3);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
