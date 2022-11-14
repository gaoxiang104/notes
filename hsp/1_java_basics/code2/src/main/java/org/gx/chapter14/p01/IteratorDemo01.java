package org.gx.chapter14.p01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorDemo01 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
        }

    }
}
