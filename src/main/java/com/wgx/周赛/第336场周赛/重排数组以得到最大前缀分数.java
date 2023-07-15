package com.wgx.周赛.第336场周赛;

import java.util.Arrays;

/**
 * @author wgx
 * @since 2023/3/12 10:39
 */
public class 重排数组以得到最大前缀分数 {
    public static void main(String[] args) {
        System.out.println(maxScore(new int[]{2,-1,0,1,-3,3,-3}));
    }

    public static int maxScore(int[] nums) {
        Arrays.sort(nums);
        long sum = 0;
        int res = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            sum += nums[i];
            if (sum > 0) {
                res++;
            }
        }
        return res;
    }
}
