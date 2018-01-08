package com.jara.alg.other;

/**
 * 不使用java api 将String转成int类型
 * 当然这个字符串本身全是数字
 * 目前的数都是不越界的整数
 * Created by Jiaqi on 2018/1/8.
 */
public class StringAndInt {

    private static boolean isPositive = true;

    public static void main(String[] args) {
        getInt("-12322422");
    }

    private static void getInt(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        char[] ch = str.toCharArray();
        int len = ch.length;
        long sum = 0;
        if (ch[0] == '-') {
            isPositive = false;
            for (int i = 1; i < len; i++) {
                sum = sum * 10 + ch[i] - '0';
            }
            System.out.println(0 - sum);
        } else {
            isPositive = true;
            for (int i = 0; i < len; i++) {
                sum = sum * 10 + ch[i] - '0';
            }
            System.out.println(sum);
        }
    }

}
