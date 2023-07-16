package com.wgx.周赛.第354场周赛;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author wgx
 * @since 2023/7/16 10:37
 */
public class 数组的最大美丽值 {
    @Test
    public void test() {
        System.out.println(maximumBeauty(new int[]{4, 6, 1, 2}, 2));
    }

    public int maximumBeauty(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        var dp = new int[n];
        int res = 0;
        for (int i = 0; i < n; ++i) {
            int j = i - 1 >= 0 ? dp[i - 1] : 1;
            while (j < n && nums[j] - k <= nums[i] + k) {
                j++;
            }
            res = Math.max(res, j - i);
            dp[i] = j;
        }
        return res;
    }

//    int n, k;
//    int[] nums;
//
//    public int maximumBeauty(int[] nums, int k) {
//        n = nums.length;
//        this.k = k;
//        this.nums = nums;
//        return dfs(0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
//    }
//
//    public int dfs(int i, int start, int end, int res) {
//        if (start != Integer.MIN_VALUE && end != Integer.MAX_VALUE && start > end) {
//            return Integer.MIN_VALUE;
//        }
//        if (i == n) {
//            return res;
//        }
//        //选
//        int select = dfs(i + 1, Math.max(start, nums[i] - k), Math.min(end, nums[i] + k), res + 1);
//        //不选
//        int noSelect = dfs(i + 1, start, end, res);
//        return Math.max(select, noSelect);
//    }
}
