package com.jara.alg.other;

import java.util.Arrays;

/**
 * 贪心算法
 * Created by Jiaqi on 2018/2/11.
 */
public class Greedy {
    private static int MAX_VALUE = 150;
    private static int[] weights = new int[] {35, 30, 60, 50, 40, 10, 25};
    private static int[] values = new int[] {10, 40, 30, 50, 35, 40, 30};

    public static void main(String[] args) {
        greedyPackage(MAX_VALUE, weights, values);
    }

    private static void greedyPackage(int capacity, int[] weights, int[] values) {
        int n = weights.length;
        double[] r = new double[n];
        int[] index = new int[n];

        for (int i = 0; i < n; i++) {
            r[i] = (double) values[i] / weights[i];
            index[i] = i;
        }

        double temp;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (r[i] < r[j]) {
                    temp = r[i];
                    r[i] = r[j];
                    r[j] = temp;
                    int x = index[i];
                    index[i] = index[j];
                    index[j] = x;
                }
            }
        }

        int[] w = new int[n];
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = weights[index[i]];
            v[i] = values[index[i]];
        }
        int[] x = new int[n];
        int value = 0;
        for (int i = 0; i < n; i++) {
            if (w[i] < capacity) {
                x[i] = 1;
                value += v[i];
                capacity = capacity - w[i];
                System.out.println("" + w[i] +"  ," + v[i]);
            }
        }
        System.out.println(Arrays.toString(x));
        System.out.println("最后最大价值:" + value);
    }
}
