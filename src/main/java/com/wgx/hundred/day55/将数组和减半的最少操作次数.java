package com.wgx.hundred.day55;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wgx
 * @since 2023/7/25 10:55
 */
public class 将数组和减半的最少操作次数 {
    public static void main(String[] args) {
        System.out.println(halveArray(new int[]{5, 19, 8, 1}));
    }

    public static int halveArray(int[] nums) {
        int n = nums.length;
        double sum = 0;
        var arr = new Double[n];
        for (int i = 0; i < n; ++i) {
            sum += nums[i];
            arr[i]  = (double) nums[i];
        }
        Arrays.sort(arr, Comparator.reverseOrder());
        int res = 0;
        var half = sum / 2;
        int index = 0;
        while (sum > half) {
            res++;
            var t = arr[index] / 2;
            sum -= t;
            arr[index] = t;
            if (index < n && arr[index] < arr[index + 1]) {
                index++;
            }
            if (index < n && arr[0] > arr[index]) {
                index = 0;
                Arrays.sort(arr, Comparator.reverseOrder());
            }
        }
        return res;
    }
}
