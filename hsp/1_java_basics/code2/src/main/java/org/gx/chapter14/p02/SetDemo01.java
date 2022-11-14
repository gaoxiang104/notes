package org.gx.chapter14.p02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetDemo01 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("A");
        set.add("B");
        set.add("C");
        set.add("E");
        set.add("D");
        set.add(null);
        set.add("E");
        set.add(null);

        System.out.println(set);

        // 修改
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.print(next + ", ");
        }
        System.out.println();


    }
}
