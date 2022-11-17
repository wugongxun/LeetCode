package com.wgx.day7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wgx
 * @version 1.0
 * @since 2022/10/14 12:27
 */
public class 三数之和 {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{0, 0, 0}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        ArrayList<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < len - 2; i++) {
            if (nums[i] > 0)
                break;
            if (i - 1 >= 0 && nums[i - 1] == nums[i])
                continue;
            int t = 0 - nums[i];
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (t == sum) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[++left]) {}
                    while (left < right && nums[right] == nums[--right]) {}
                } else if (t < sum) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }
}
