package com.wgx.fifty.day26;

import java.util.Arrays;

/**
 * @author wgx
 * @since 2023/2/28 10:28
 * <p>
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * <p>
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 */
public class 最长递增子序列 {
    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{0,1,0,3,2,3}));
    }

    public static int lengthOfLIS(int[] nums) {
        int ng = 0;
        for (var num : nums) {
            int j = Arrays.binarySearch(nums, 0, ng, num);
            if (j >= 0) {
                continue;
            }
            j = -j - 1;
            nums[j] = num;
            if (j == ng) {
                ++ng;
            }
        }
        return ng;
    }
}
