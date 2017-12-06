package com.jara.alg.sort;

/**
 * 快速排序
 * Created by Jiaqi on 2017/12/6.
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {4,3,1,5,7,9,10};
        QuickSort sort = new QuickSort();
        sort.sort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private int[] sort(int[] arr, int low, int high) {
        if (low < high) {
            int result = partition(arr, low, high);
            partition(arr, low, result - 1);
            partition(arr, result + 1, high);
        }
        return arr;
    }

    /**
     * 快排的前提要指定一个key 一般都是下角标最小的 最为参照
     * 然后根据这个key最后落在的位置分隔要排的串 再分别对两部分排序
     * @param arr
     * @param low
     * @param high
     * @return
     */
    private int partition(int[] arr, int low, int high) {
        int key = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= key) {
                high--;
            }
            if (low < high) {
                arr[low] = arr[high];
            }
            while (low < high && arr[low] <= key) {
                low++;
            }
            if (low < high) {
                arr[high] = arr[low];
            }
        }
        arr[low] = key;
        return low;
    }

}
