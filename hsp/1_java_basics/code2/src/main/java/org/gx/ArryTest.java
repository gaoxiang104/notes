package org.gx;

/**
 * 冒泡排序,从小到大排
 */
public class ArryTest {
    public static void main(String[] args) {
        int[] arr = {10, -1, 0, 3, 2, 9, 6, 4, 7, 8};

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int n = arr[i];
                if (n > arr[j]) {
                    arr[i] = arr[j];
                    arr[j] = n;
                }
            }
        }


        showArr(arr);
    }

    public static void showArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
