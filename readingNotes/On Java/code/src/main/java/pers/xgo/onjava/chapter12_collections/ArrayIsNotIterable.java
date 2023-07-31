package pers.xgo.onjava.chapter12_collections;

import java.util.Arrays;

public class ArrayIsNotIterable {
    static <T> void test(Iterable<T> ib) {
        for (T t : ib) {
            System.out.print(t + " ");
        }
    }

    public static void main(String[] args) {
        test(Arrays.asList(1, 2, 3));
        String[] strings = {"A", "B", "C"};
        // 数组可以配合 for-in 使用，但并没有实现 Iterable 接口：
        // test(strings);
        // 错误：必须显式地将其转换为 Iterable
        test(Arrays.asList(strings));
    }
}
