package com.wgx.笔试.乌鸫科技;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author wgx
 * @since 2023/8/18 12:18
 */
public class Solution {
    public static void main(String[] args) {
        test(new int[]{1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 19});
    }

    public static void test(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
//                for (int k = 2; k < n; ++k) {
//                    if (k == i || k == j)
//                        continue;
//                    int l = 0, r = k - 1;
//                    int target = nums[i] * nums[j] - nums[k];
//                    while (l < r) {
//                        if (l == i || l == j) {
//                            l++;
//                            continue;
//                        }
//                        if (r == i || r == j) {
//                            r--;
//                            continue;
//                        }
//                        int sum = nums[l] + nums[r];
//                        if (sum == target) {
//                            System.out.println(nums[l] + nums[r] + nums[k] == nums[i] * nums[j]);
//                            System.out.println(nums[l] + "-" + nums[r] + "-" + nums[k] + "-" + nums[i] + "-" + nums[j]);
//                            break;
//                        } else if (sum > target) {
//                            r--;
//                        } else {
//                            l++;
//                        }
//                    }
//                }
                 for (int l = 0; l < n; ++l) {
                     if (l == i || l == j)
                         continue;
                     for (int r = l + 1; r < n; ++r) {
                         if (r == i || r == j)
                             continue;
                         int index = Arrays.binarySearch(nums, r + 1, n, nums[i] * nums[j] - nums[l] - nums[r]);
                         if (index >= 0 && index != i && index != j) {
                             System.out.println(nums[l] + nums[r] + nums[index] == nums[i] * nums[j]);
                             System.out.println(nums[l] + "-" + nums[r] + "-" + nums[index] + "-" + nums[i] + "-" + nums[j]);
                         }
                     }
                 }
            }
        }

    }
}
