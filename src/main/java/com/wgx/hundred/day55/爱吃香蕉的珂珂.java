package com.wgx.hundred.day55;

import java.util.Arrays;

/**
 * @author wgx
 * @since 2023/7/26 21:08
 */
public class 爱吃香蕉的珂珂 {
    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[]{1, 1, 1, 999999999}, 10));
//        System.out.println(minEatingSpeed(new int[]{312884470}, 312884469));
//        System.out.println(minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int max = Arrays.stream(piles).max().getAsInt();
        if (h == n) {
            return max;
        }
        int l = 1, r = max;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            long t = 0;
            for (int i = 0; i < n; ++i) {
                t += (piles[i] - 1) / mid + 1;
            }

            if (t > h) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
