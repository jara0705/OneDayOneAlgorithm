package com.jara.alg.sort;

/**
 * 选择排序
 * Created by Jiaqi on 2018/1/28.
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = {4, 3, 1, 5, 7, 9, 10};
        sort(arr);
    }

    private static void sort(int[] arr) {
        int len = arr.length;
        int i;
        int j;
        int t;
        for (i = 0; i < len; i++) {
            int index = i;
            for (j = i + 1; j < len; j++) {
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }
            t = arr[i];
            arr[i] = arr[index];
            arr[index] = t;
        }
        for (int a = 0; a < len; a++) {
            System.out.print(arr[a]);
        }
    }

}
