package org.gx.chapter14.p01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListDemo02 {
    public static void main(String[] args) {
        List<String> l1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            l1.add(Character.toString('A' + i));
        }
        System.out.println(l1);

        // 在2号位插入一个元素
        l1.add(1, "123");
        System.out.println(l1);

        // 获取第5个元素
        System.out.println(l1.get(4));

        // 删除第六个元素
        l1.remove(5);
        System.out.println(l1);

        // 修改第7个元素
        l1.set(6, "321");
        System.out.println(l1);

        // 遍历
        Iterator<String> iterator = l1.iterator();
        while (iterator.hasNext()) {
            String o = iterator.next();
            System.out.println(o);
        }
    }
}
