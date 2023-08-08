package com.wgx.hundred.day60;

/**
 * @author wgx
 * @since 2023/8/8 9:59
 */
public class 任意子数组和的绝对值的最大值 {
    public static void main(String[] args) {
//        System.out.println(maxAbsoluteSum(new int[]{2, -5, 1, -4, 3, -2}));
        System.out.println(maxAbsoluteSum(new int[]{-7, -1, 0, -2, 1, 3, 8, -2, -6, -1, -10, -6, -6, 8, -4, -9, -4, 1, 4, -9}));
    }

    public static int maxAbsoluteSum(int[] nums) {
        int sum = 0, max = 0, min = 0;
        for (var num : nums) {
            sum += num;
            max = Math.max(max, sum);
            min = Math.min(min, sum);
        }
        return max - min;
    }

//    public static int maxAbsoluteSum(int[] nums) {
//        int n = nums.length;
//        int negative = 0, positive = 0;
//        int res = 0;
//        for (int i = 0; i < n; ++i) {
//            if (nums[i] > 0) {
//                negative = Math.max(negative - nums[i], 0);
//                positive += nums[i];
//            } else {
//                int abs = -nums[i];
//                negative += abs;
//                positive = Math.max(positive - abs, 0);
//            }
//            res = Math.max(res, Math.max(negative, positive));
//        }
//        return res;
//    }
}
