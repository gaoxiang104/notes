package org.gx.chapter13.p05;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ArraysDemo01 {
    public static void main(String[] args) {
        // 1. 返回数组的字符串形式
        int[] arr1 = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(arr1));

        // 2. 排序（自然拍下和定制排序）；
        Integer[] arr2 = {1, 0, 3, 2, -1, 8, 5};
        System.out.println("排序前：" + Arrays.toString(arr2));
        Arrays.sort(arr2);
        System.out.println("排序后：" + Arrays.toString(arr2));
        // 2.1 定制排序
        Arrays.sort(arr2, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println("指定 comparator 排序后：" + Arrays.toString(arr2));
        // 2.2. 自定义定制冒泡
        bubble(arr2, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println("定制冒泡, 排序后：" + Arrays.toString(arr2));

        // 3. binarySearch 通过二分搜索法进行查找，要求必须排好序；
        Integer[] arr3 = {1, 0, 3, 2, -1, 8, 5};
        Arrays.sort(arr3);
        int i = Arrays.binarySearch(arr3, -2); // 如果查找的元素不存在，返回负数
        System.out.println(i);

        // 4. copyOf 数组元素的复制
        Integer[] arr4 = Arrays.copyOf(arr3, 3);
        System.out.println(Arrays.toString(arr4));

        // 5. fill 数组元素的填充
        Integer[] arr5 = {1, 2, 3};
        Arrays.fill(arr5, 0); // 用0替换数组中的所有元素
        System.out.println(Arrays.toString(arr5));

        // 6. equals 比较两个数组元素内容是否完全一致
        System.out.println(Arrays.equals(arr4,arr5));

        // asList 将一组值，转换成List
        List<Integer> list = Arrays.asList(arr5);
        System.out.println(list);
        System.out.println(list.getClass());
    }

    // 定制冒泡
    public static void bubble(Integer[] arr, Comparator<Integer> c) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (c.compare(arr[j], arr[j + 1]) < 0) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
