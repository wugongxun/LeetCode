package com.wgx.第352场周赛;

/**
 * @author wgx
 * @since 2023/7/2 10:39
 */
public class 最长奇偶子数组 {
    public static void main(String[] args) {
        System.out.println(longestAlternatingSubarray(new int[]{2, 8}, 4));
//        System.out.println(longestAlternatingSubarray(new int[]{1, 10, 5}, 9));
//        System.out.println(longestAlternatingSubarray(new int[]{2, 3, 4, 5}, 4));
    }

    public static int longestAlternatingSubarray(int[] nums, int threshold) {
        int n = nums.length;
        int res = 0;
        int i = 0;
        while (i < n) {
            if (nums[i] > threshold || nums[i] % 2 == 1) {
                i++;
            } else {
                int t = i;
                i++;
                while (i < n && nums[i] <= threshold && nums[i] % 2 != nums[i - 1] % 2) {
                    i++;
                }
                res = Math.max(res, i - t);
            }
        }
        return res;
    }

}
