package org.gx.chapter08.p02;

import java.util.Scanner; // 表示只会引入java.util 包下的Scanner 类
import java.util.*; // 表示将java.util包下的所有类都引入（导入）

public class Package01 {
    public static void main(String[] args) {
        int[] arr = {10,-1,2,4,5,6,8,3};
        Arrays.sort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
