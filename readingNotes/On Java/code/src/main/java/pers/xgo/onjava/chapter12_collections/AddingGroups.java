package pers.xgo.onjava.chapter12_collections;

import java.util.*;

// 向 Collection 对象中添加一组元素
public class AddingGroups {
    public static void main(String[] args) {
        Collection<Integer> collection =
                new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Integer[] moreInts = {6, 7, 8, 9, 10};
        collection.addAll(Arrays.asList(moreInts));
        // 运行快很多，但是我们无法以这种方式构建 Collection
        Collections.addAll(collection, 11,12,13,14,15);
        Collections.addAll(collection,moreInts);
        // 生成一个底层为数组的列表
        List<Integer> list = Arrays.asList(16,17,18,19,20);
        list.set(1,99); // 修改元素
        // list.add(21); // 运行时错误；底层的数组不能调整大学

    }
}
