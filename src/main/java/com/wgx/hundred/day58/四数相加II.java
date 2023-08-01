package com.wgx.hundred.day58;

import java.util.HashMap;

/**
 * @author wgx
 * @since 2023/7/31 11:08
 */
public class 四数相加II {
    public static void main(String[] args) {
        System.out.println(fourSumCount(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2}));
    }
    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int n = nums1.length;
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = nums1[i] + nums2[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = nums3[i] + nums4[j];
                if (map.containsKey(-sum)) {
                    res += map.get(-sum);
                }
            }
        }
        return res;
    }

}
