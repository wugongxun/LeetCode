package com.wgx.fifty.day47;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author wgx
 * @since 2023/7/1 12:47
 */
public class 求出最多标记下标 {
    @Test
    public void test() {
//        System.out.println(maxNumOfMarkedIndices(new int[]{9, 2, 5, 4}));
        System.out.println(maxNumOfMarkedIndices(new int[]{3, 5, 2, 4}));
    }

    //双指针
//    public int maxNumOfMarkedIndices(int[] nums) {
//        Arrays.sort(nums);
//        int i = 0, n = nums.length;
//        for (int j = (n + 1) / 2; j < n; ++j) {
//            if (2 * nums[i] <= nums[j]) {
//                ++i;
//            }
//        }
//        return 2 * i;
//    }

//    二分
    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = nums.length / 2;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (check(nums, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right * 2;
    }

    public boolean check(int[] nums, int k) {
        for (int i = 0; i < k; ++i) {
            if (nums[i] * 2 > nums[nums.length - k + i]) {
                return false;
            }
        }
        return true;
    }
}
