package com.wgx.day2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wgx
 * @version 1.0
 * @since 2022/9/27 17:17
 */
public class 两数之和 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int[] sum = twoSum(nums, 6);
        System.out.println(Arrays.toString(sum));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (m.get(target - nums[i]) != null) {
                return new int[]{m.get(target - nums[i]), i};
            }
            m.put(nums[i], i);
        }
        return new int[]{0, 0};
    }
}
