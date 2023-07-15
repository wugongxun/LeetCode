package com.wgx.fifty.day50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wgx
 * @since 2023/7/15 12:40
 */
public class 四数之和 {
    public static void main(String[] args) {
//        System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
//        System.out.println(fourSum(new int[]{2, 2, 2, 2, 2}, 8));
//        System.out.println(fourSum(new int[]{1, -2, -5, -4, -3, 3, 3, 5}, -11));
        System.out.println(fourSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000}, -294967296));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        var res = new ArrayList<List<Integer>>();
        for (int i = 0; i < n - 2; ++i) {
            if (i - 1 >= 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < n - 2; ++j) {
                if (j - 1 > i && nums[j] == nums[j - 1]) {
                    continue;
                }
                long t = (long) target - nums[i] - nums[j];
                int left = j + 1, right = n - 1;
                while (left < right) {
                    int sum = nums[left] + nums[right];
                    if (sum == t) {
                        res.add(List.of(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[++left]) {
                        }
                        while (left < right && nums[right] == nums[--right]) {
                        }
                    } else if (t < sum) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return res;
    }
}
