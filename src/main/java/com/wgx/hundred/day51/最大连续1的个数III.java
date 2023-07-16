package com.wgx.hundred.day51;

/**
 * @author wgx
 * @since 2023/7/16 16:06
 */
public class 最大连续1的个数III {
    public static void main(String[] args) {
//        System.out.println(longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
        System.out.println(longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
    }

    public static int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int lsum = 0, rsum = 0;
        int res = 0;
        for (int right = 0; right < n; ++right) {
            rsum += 1 - nums[right];
            while (lsum + k < rsum) {
                lsum += 1 - nums[left++];
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
