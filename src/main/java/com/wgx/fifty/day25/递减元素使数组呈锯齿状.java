package com.wgx.fifty.day25;

/**
 * @author wgx
 * @since 2023/2/27 9:38
 */
public class 递减元素使数组呈锯齿状 {
    public static void main(String[] args) {
        System.out.println(movesToMakeZigzag(new int[]{2, 7, 10, 9, 8, 9}));
    }

    public static int movesToMakeZigzag(int[] nums) {
        return Math.min(operation(nums, 0), operation(nums, 1));
    }

    public static int operation(int[] nums, int start) {
        int res = 0;
        for (int i = start; i < nums.length; i += 2) {
            if (i - 1 < 0) {
                if (nums[i] >= nums[i + 1]) {
                    res += nums[i] - nums[i + 1] + 1;
                }
                continue;
            }
            if (i + 1 >= nums.length) {
                if (nums[i] >= nums[i - 1]) {
                    res += nums[i] - nums[i - 1] + 1;
                }
                continue;
            }
            int min = Math.min(nums[i - 1], nums[i + 1]);
            if (nums[i] >= min) {
                res += nums[i] - min + 1;
            }
        }
        return res;
    }
}
