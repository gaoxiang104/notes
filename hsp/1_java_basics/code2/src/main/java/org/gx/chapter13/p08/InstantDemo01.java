package org.gx.chapter13.p08;

import java.time.Instant;
import java.util.Date;

public class InstantDemo01 {
    public static void main(String[] args) {
        // Instant --> Date
        Instant i = Instant.now();
        System.out.println(i);
        Date d = Date.from(i);
        System.out.println(d);
        // Date --> Instant
        Instant i2 = d.toInstant();
        System.out.println(i2);
    }
}
