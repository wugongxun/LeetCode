package com.wgx.day36;

import java.util.Arrays;

/**
 * @author wgx
 * @since 2023/4/25 10:52
 */
public class 分割等和子集 {
    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,100}));
    }

    public static boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        var dp = new boolean[target + 1];
        dp[0] = true;
        for (var num : nums) {
            for (int j = target; j >= num; --j) {
                dp[j] |= dp[j - num];
            }
        }
        return dp[target];
    }

//    public static boolean canPartition(int[] nums) {
//        int sum = 0;
//        int maxNum = 0;
//        int n = nums.length;
//        if (n < 2) {
//            return false;
//        }
//        for (int i = 0; i < n; ++i) {
//            maxNum = Math.max(maxNum, nums[i]);
//            sum += nums[i];
//        }
//        if (sum % 2 != 0) {
//            return false;
//        }
//        int target = sum / 2;
//        if (maxNum > target) {
//            return false;
//        }
//        if (maxNum == target) {
//            return true;
//        }
//
//        var dp = new boolean[n][target + 1];
//        Arrays.setAll(dp, i -> dp[i][0] = true);
//        dp[0][nums[0]] = true;
//        for (int i = 1; i < n; ++i) {
//            int num = nums[i];
//            for (int j = 1; j <= target; ++j) {
//                if (j >= num) {
//                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - num];
//                } else {
//                    dp[i][j] = dp[i - 1][j];
//                }
//            }
//        }
//        return dp[n - 1][target];
//    }
}
