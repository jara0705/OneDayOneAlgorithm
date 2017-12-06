package com.jara.alg.sort;

/**
 * 冒泡排序
 * Created by Jiaqi on 2017/12/6.
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {4,3,1,5,7,9,10};
        sort(arr);
    }

    private static void sort(int[] arr) {

        int i;
        int j;

        int len = arr.length - 1;

        for (i = 0; i < len; i++) {
            for (j = 0; j < len - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        for (int a : arr) {
            System.out.print(a + " ");
        }
    }

    private static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }
}
