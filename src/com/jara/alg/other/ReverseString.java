package com.jara.alg.other;

/**
 * Created by Jiaqi on 2018/3/6.
 */
public class ReverseString {

    public static void main(String[] args) {
        String s = "Hello world";
        reverse(s);
    }

    private static void reverse(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        for (int i = n - 1; i >= 0; i--) {
            System.out.print(arr[i]);
        }
    }
}
