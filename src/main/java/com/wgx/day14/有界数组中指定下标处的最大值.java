package com.wgx.day14;

import java.util.Arrays;

/**
 * @author wgx
 * @since 2023/1/4 10:13
 */
public class 有界数组中指定下标处的最大值 {
    public static void main(String[] args) {
        System.out.println(maxValue(6, 1, 10));
    }

    public static int maxValue(int n, int index, int maxSum) {
        maxSum -= n;
        int res = 1;
        while (maxSum >= 0) {
            if (res == Math.max(index + 1, n - index)) {
                int q = maxSum / n;
                return q + res;
            }
            res++;
            maxSum--;
            maxSum -= Math.min(index, res - 2);
            maxSum -= Math.min(n - 1 - index, res - 2);
        }
        return res - 1;
    }
}
