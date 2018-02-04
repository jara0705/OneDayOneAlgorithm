package com.jara.alg.sort;

/**
 * Created by Jiaqi on 2018/2/4.
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {4, 3, 1, 5, 7, 9, 10};
        directSort(arr);
        System.out.println();
        binarySort(arr);
    }

    /**
     * 直接插入排序
     * 稳定排序
     *
     * @param arr
     */
    private static void directSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] > temp) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = temp;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
    }

    /**
     * 二分法排序
     *
     * @param arr
     */
    private static void binarySort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            int left = 0;
            int right = i - 1;
            int mid = 0;
            while (left <= right) {
                mid = (left + right) / 2;
                if (temp < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            for (int j = i - 1; j >= left; j--) {
                arr[j + 1] = arr[j];
            }
            if (left != i) {
                arr[left] = temp;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
    }

}
