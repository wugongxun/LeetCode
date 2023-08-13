package com.wgx.周赛.第358场周赛;

/**
 * @author wgx
 * @since 2023/8/13 10:31
 */
public class 数组中的最大数对和 {
    public static void main(String[] args) {

    }

    public int maxSum(int[] nums) {
        int n = nums.length;
        var max = new int[n];
        for (int i = 0; i < n; i++) {
            var t = nums[i];
            var maxBit = 0;
            while (t != 0) {
                maxBit = Math.max(maxBit, t % 10);
                t /= 10;
            }
            max[i] = maxBit;
        }
        int res = -1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (max[i] == max[j])
                    res = Math.max(res, nums[i] + nums[j]);
            }
        }
        return res;
    }
}
