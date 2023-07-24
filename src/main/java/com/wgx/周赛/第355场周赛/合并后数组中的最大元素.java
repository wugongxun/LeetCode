package com.wgx.周赛.第355场周赛;

/**
 * @author wgx
 * @since 2023/7/23 10:45
 */
public class 合并后数组中的最大元素 {
    public static void main(String[] args) {
        System.out.println(maxArrayValue(new int[]{2, 3, 7, 9, 3}));
        System.out.println(maxArrayValue(new int[]{77}));
    }

    public static long maxArrayValue(int[] nums) {
        int n = nums.length;
        long sum = nums[n - 1];
        long res = sum;
        for (int i = n - 2; i >= 0; --i) {
            if (nums[i] <= sum) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            res = Math.max(res, sum);
        }
        return res;
    }
}
