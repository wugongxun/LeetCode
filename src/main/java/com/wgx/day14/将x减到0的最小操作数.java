package com.wgx.day14;

import java.util.Arrays;

/**
 * @author wgx
 * @since 2023/1/7 13:58
 */
public class 将x减到0的最小操作数 {
    public static void main(String[] args) {
        int[] nums = new int[]{5,2,3,1,1};
        System.out.println(minOperations(nums, 5));
    }

//    public static int minOperations(int[] nums, int x) {
//        int total = Arrays.stream(nums).sum();
//        int dif = total - x;
//        if (dif == 0) {
//            return nums.length;
//        }
//        if (dif < 0) {
//            return -1;
//        }
//        int start = 0, end = 0, sum = 0, n = nums.length, res = -1;
//        while (end < n) {
//            sum += nums[end];
//            while (sum >= dif) {
//                if (sum == dif) {
//                    res = Math.max(res, end - start + 1);
//                }
//                sum -= nums[start];
//                start++;
//            }
//            end++;
//        }
//        return res == -1 ? res : n - res;
//    }

    public static int minOperations(int[] nums, int x) {
        int n = nums.length;
        int total = Arrays.stream(nums).sum();
        int dif = total - x;
        if (dif == 0) {
            return n;
        }
        if (dif < 0) {
            return -1;
        }
        int[] snums = new int[n + 1];
        int res = -1;
        for (int i = 1; i <= n; i++) {
            snums[i] = snums[i - 1] + nums[i - 1];
        }
        for (int i = 0; i < n; i++) {
            int s = dif + snums[i];
            int index = Arrays.binarySearch(snums, s);
            if (index > 0 && index <= n) {
                res = Math.max(res, index - i);
            }
        }
        return res == -1 ? res : n - res;
    }
}
