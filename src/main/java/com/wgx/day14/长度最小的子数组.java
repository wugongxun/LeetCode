package com.wgx.day14;

import java.util.Arrays;

/**
 * @author wgx
 * @since 2023/1/7 15:19
 */
public class 长度最小的子数组 {
    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }

//    public static int minSubArrayLen(int target, int[] nums) {
//        int n = nums.length;
//        if (n == 0)
//            return 0;
//        int res = n + 1;
//        int[] snums = new int[n + 1];
//        for (int i = 1; i <= n; i++) {
//            snums[i] = snums[i - 1] + nums[i - 1];
//        }
//        for (int i = 0; i < n; i++) {
//            int s = target + snums[i];
//            int index = Arrays.binarySearch(snums, s);
//            if (index < 0) {
//                index = -index - 1;
//            }
//            if (index <= n) {
//                res = Math.min(res, index - i);
//            }
//        }
//        return res > n ? 0 : res;
//    }

    public static int minSubArrayLen(int target, int[] nums) {
        int start = 0, end = 0, sum = 0, n = nums.length, res = n + 1;
        while (end < n) {
            sum += nums[end];
            while (sum >= target) {
                res = Math.min(res, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return res > n ? 0 : res;
    }
}
