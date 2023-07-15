package com.wgx.周赛.第336场周赛;

import java.util.HashMap;

/**
 * @author wgx
 * @since 2023/3/12 10:53
 * 1674 ms 2755975
 */
public class 统计美丽子数组数目 {
    public static void main(String[] args) {
        System.out.println(beautifulSubarrays(new int[]{0}));
    }

    public static long beautifulSubarrays(int[] nums) {

        long res = 0;
        int n = nums.length;
        var prefix = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            prefix[i + 1] = prefix[i] ^ nums[i];
        }

        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i <= n; i++) {
            res += map.getOrDefault(prefix[i], 0);
            map.merge(prefix[i], 1, Integer::sum);
        }
        return res;
    }
}
