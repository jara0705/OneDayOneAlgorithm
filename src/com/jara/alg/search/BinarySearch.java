package com.jara.alg.search;

/**
 * 二分查找法
 * Created by Jiaqi on 2017/12/9.
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1,3,4,6,8,9,10};
        System.out.println(search(arr, 3));
        System.out.println(search2(arr, 3, 6, 0));
    }

    private static int search(int[] arr, int value) {
        int len = arr.length;
        int low = 0;
        int high = len - 1;
        int mid;
        while(low < high) {
            mid = (high + low) / 2;
            if (value == arr[mid]) {
                return mid;
            }
            if (arr[mid] > value) {
                high = mid - 1;
            }
            if (arr[mid] < value) {
                low = mid + 1;
            }
        }
        return -1;
    }

    private static int search2(int[] arr,int value, int high, int low) {
        int mid = (high + low) / 2;
        if (arr[mid] == value) {
            return mid;
        }
        if (arr[mid] > value) {
            return search2(arr, value, mid - 1, low);
        }
        if (arr[mid] < value) {
            return search2(arr, value, high, mid + 1);
        }
        return -1;
    }

}
