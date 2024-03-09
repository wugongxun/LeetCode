package com.wgx.笔试.乌鸫科技;

import java.util.Arrays;

/**
 * @author wgx
 * @since 2023/8/18 12:18
 */
public class Solution {
    public static void main(String[] args) {
        solution(new int[]{2, 1, 3, 4, 6, 5, 7});
        solution(new int[]{1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 19});
    }

    public static void solution(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int count = 0;
        for (int x = 0; x < n; ++x) {
            for (int y = x + 1; y < n; ++y) {
                for (int a = 0; a < n; ++a) {
                    if (a == x || a == y)
                        continue;
                    int target = nums[x] * nums[y] - nums[a];
                    for (int b = a + 1; b < n; ++b) {
                        if (b == x || b == y)
                            continue;
                        int c = n - 1;
                        while (b < c) {
                            if (c != x && c != y && nums[b] + nums[c] == target) {
                                count++;
                                break;
                            }
                            if (nums[b] + nums[c] < target)
                                break;
                            c--;
                        }
                    }
                }

//                for (int l = 0; l < n; ++l) {
//                    if (l == i || l == j)
//                        continue;
//                    for (int r = l + 1; r < n; ++r) {
//                        if (r == i || r == j)
//                            continue;
//                        int index = Arrays.binarySearch(nums, r + 1, n, nums[i] * nums[j] - nums[l] - nums[r]);
//                        if (index >= 0 && index != i && index != j) {
//                            count++;
//                            System.out.println(nums[l] + nums[r] + nums[index] == nums[i] * nums[j]);
//                            System.out.println(nums[l] + "-" + nums[r] + "-" + nums[index] + "-" + nums[i] + "-" + nums[j]);
//                        }
//                    }
//                }
            }
        }
        System.out.println(count);
    }

    public static void s(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int x = 0; x < n; ++x)
            for (int y = x + 1; y < n; ++y)
                for (int a = 0; a < n; ++a) {
                    if (a == x || a == y)
                        continue;
                    for (int b = a + 1; b < n; ++b) {
                        if (b == x || b == y)
                            continue;
                        for (int c = b + 1; c < n; ++c) {
                            if (c == x || c == y)
                                continue;
                            if (nums[x] * nums[y] == nums[a] + nums[b] + nums[c])
                                count++;
                        }
                    }
                }
        System.out.println(count);
    }
}
