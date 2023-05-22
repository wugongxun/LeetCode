package com.wgx.day41;

import java.util.Arrays;

/**
 * @author wgx
 * @since 2023/5/21 11:52
 */
public class 蓄水 {
    public static void main(String[] args) {
        System.out.println(storeWater(new int[]{0}, new int[]{1}));
    }

    public static int storeWater(int[] bucket, int[] vat) {
        int n = bucket.length;
        int maxk = Arrays.stream(vat).max().getAsInt();
        if (maxk == 0) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for (int k = 1; k <= maxk && k < res; ++k) {
            int t = 0;
            for (int i = 0; i < n; ++i) {
                t += Math.max(0, (vat[i] + k - 1) / k - bucket[i]);
            }
            res = Math.min(res, t + k);
        }
        return res;
    }
}
