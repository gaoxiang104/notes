package org.gx.chapter14.p01;

import java.util.ArrayList;
import java.util.List;

public class ListDemo01 {
    public static void main(String[] args) {
        List<String> l1 = new ArrayList<>();
        // 默认在结尾处添加
        l1.add("A");
        l1.add("C");

        // 在指定位置添加；从index=1的位置插入一个对象
        l1.add(1, "B");
        System.out.println(l1);

        // 在指定位置添加多个
        List<String> l2 = new ArrayList<>();
        l2.add("E");
        l2.add("F");
        l1.addAll(1,l2);
        System.out.println(l1);

        // 取出指定index位置的元素
        System.out.println(l1.get(1));

        // 查找obj在集合中首次出现的位置
        System.out.println(l1.indexOf("B"));
        // 查找obj在集合中末次出现的位置
        System.out.println(l1.lastIndexOf("E"));

        // 删除指定index位置的元素
        l1.remove(0);
        System.out.println(l1);

        // 替换指定index位置的元素
        l1.set(0,"G");
        System.out.println(l1);

        // 返回从fromIndex到toIndex位置的子集合【前闭后开】
        System.out.println(l1.subList(1,3));
    }
}
