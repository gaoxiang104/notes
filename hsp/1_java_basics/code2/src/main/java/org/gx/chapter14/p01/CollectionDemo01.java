package org.gx.chapter14.p01;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionDemo01 {
    public static void main(String[] args) {
        Collection c = new ArrayList();
        // add：添加单个元素
        c.add("Aoo");
        c.add(1);
        System.out.println(c);

        // remove：删除指定元素
        c.remove("Aoo");
        System.out.println(c);

        // contains：查找元素是否存在
        c.add("Boo");
        System.out.println(c.contains("Boo"));

        // size：获取元素个数
        System.out.println(c.size());

        // isEmpty：判断是否为空
        System.out.println(c.isEmpty());

        // clear：清空
        c.clear();
        System.out.println(c.isEmpty());

        // addAll：添加多个元素
        Collection c2 = new ArrayList();
        c2.add("A");
        c2.add("B");
        c2.add("C");

        c.addAll(c2);
        System.out.println(c);

        // containsAll：查找多个元素是否都存在
        Collection c3 = new ArrayList();
        c3.add("A");
        c3.add("C");
        System.out.println(c.containsAll(c3));

        // removeAll：删除多个元素
        c.removeAll(c3);
        System.out.println(c);
    }
}
