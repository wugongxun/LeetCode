package com.wgx.day1;

import java.util.Arrays;

/**
 * @author wgx
 * @version 1.0
 * @since 2022/9/25 14:20
 */
public class 旋转数组 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }

    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        int[] temp = new int[len];
        for (int i = 0; i < len; i++) {
            temp[i] = nums[i];
        }
        for (int i = 0; i < len; i++) {
                nums[(i + k) % len] = temp[i];
        }
    }
}
