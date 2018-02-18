package com.jara.alg.sort;

/**
 * 归并排序
 * Created by Jiaqi on 2018/2/18.
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {4, 3, 1, 5, 7, 9, 10};
        sort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
    }

    private static void sort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            sort(arr, left, middle);
            sort(arr, middle + 1, right);
            merge(arr, left, middle, right); // 合并
        }
    }

    private static void merge(int[] arr, int left, int middle, int right) {
        int[] temp = new int[arr.length];
        int rightStart = middle + 1;
        int tmp = left;
        int third = left;
        // 左右数组合并并排序
        while (left <= middle && rightStart <= right) {
            if (arr[left] <= arr[rightStart]) {
                temp[third++] = arr[left++];
            } else {
                temp[third++] = arr[rightStart++];
            }
        }
        while (left <= middle) {
            temp[third++] = arr[left++];
        }
        while (rightStart <= right) {
            temp[third++] = arr[rightStart++];
        }
        while(tmp <= right) {
            arr[tmp] = temp[tmp++];
        }

    }

}
