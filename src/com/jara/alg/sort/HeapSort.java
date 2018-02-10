package com.jara.alg.sort;

/**
 * 堆排序
 * Created by Jiaqi on 2018/2/10.
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {4, 3, 15, 5, 7, 29, 10, 33, 22};
        sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(" " + arr[i]);
        }
    }

    private static void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        buildHeap(arr);
        for (int i = arr.length - 1; i >= 1; i--) {
            exchange(arr, 0, i);
            maxHeap(arr, i, 0);
        }
    }

    private static void buildHeap(int[] arr) {
        int half = (arr.length - 1) / 2;
        for (int i = half; i >= 0; i--) {
            maxHeap(arr, arr.length, i);
        }
    }

    private static void maxHeap(int[] arr, int length, int i) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int large = i;
        if (left < length && arr[left] > arr[i]) {
            large = left;
        }
        if (right < length && arr[right] > arr[large]) {
            large = right;
        }
        if (i != large) {
            exchange(arr, i, large);
            maxHeap(arr, length, large);
        }
    }

    private static void exchange(int[] arr, int i, int large) {
        int temp = arr[i];
        arr[i] = arr[large];
        arr[large] = temp;
    }

}
