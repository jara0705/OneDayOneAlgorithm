package com.jara.alg.other;

/**
 * 跳台阶问题 n级 每次可眺1级或2级
 * 斐波那契思想
 * Created by Jiaqi on 2018/1/10.
 */
public class Fibonacci002 {

    public static void main(String[] args) {
        System.out.println(getCount(4));
        System.out.println(getCount2(4));
    }

    private static int getCount(int n) {
        if (n == 2) return 2;
        if (n == 1) return 1;
        if (n == 0) return 0;
        return getCount(n - 1) + getCount(n - 2);
    }
    // 1 2 3 5 8 13 ...
    private static int getCount2(int n) {
        if (n < 2) {
            return 1;
        }
        int a = 1;
        int b = 1;
        int c = 0;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

}
