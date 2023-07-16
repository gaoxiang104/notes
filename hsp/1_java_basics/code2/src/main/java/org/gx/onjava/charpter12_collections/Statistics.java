package org.gx.onjava.charpter12_collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

// HashMap 的简单演示
public class Statistics { // 统计学
    public static void main(String[] args) {
        Random rand = new Random(47);
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < 10000; i++) {
            // 生成一个 0~20 范围内的数
            int r = rand.nextInt(20);
            Integer freq = m.get(r);
            m.put(r, freq == null ? 1 : freq + 1); // 统计随机数r 出现了多少次
        }
        System.out.println(m);
    }
}
