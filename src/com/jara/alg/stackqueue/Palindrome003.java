package com.jara.alg.stackqueue;

import java.util.Stack;

/**
 * 使用栈结构判断字符串是否回文
 * 中心思想就是将整个字符串拆分成前后两段
 * 入栈前半段 与 后半段进行比较
 * Created by Jiaqi on 2017/12/5.
 */
public class Palindrome003 {

    public static void main(String[] args) {
        String string = "asdffdsa";
        System.out.println(isPalindrome(string));
    }

    public static boolean isPalindrome(String str) {
        char[] array = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        int length = array.length;
        int mid = length / 2;
        int right;
        if (length % 2 == 0) {
            right = mid;
        } else {
            right = mid + 1;
        }
        for (int i = 0; i < mid; i++) {
            stack.push(array[i]);
        }
        while(!stack.empty()) {
            if (!stack.pop().equals(array[right])) {
                return false;
            }
            right++;
        }
        return true;
    }

}
