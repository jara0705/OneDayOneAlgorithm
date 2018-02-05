package com.jara.alg.sort;

/**
 * 希尔排序
 * 不稳定
 * Created by Jiaqi on 2018/2/5.
 */
public class HeerSort {
    public static void main(String[] args) {
        int[] arr = {4, 3, 1, 5, 7, 9, 10};
        sort(arr);
    }

    private static void sort(int[] arr) {
        int d = arr.length / 2;
        while (true) {
            for (int i = 0; i < d; i++) {
                for (int j = i; j + d < arr.length; j += d) {
                    int temp;
                    if (arr[j] > arr[j + d]) {
                        temp = arr[j];
                        arr[j] = arr[j + d];
                        arr[j + d] = temp;
                    }
                }
            }
            if (d == 1) {
                break;
            }
            d--;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
    }
}
