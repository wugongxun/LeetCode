package com.wgx.day20;

import java.util.Arrays;

/**
 * @author wgx
 * @since 2023/2/7 11:38
 */
public class 在排序数组中查找元素的第一个和最后一个位置 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5,7,7,8,8,10}, 8)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        int start = -1, end = -1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (target == nums[mid]) {
                int i = 1, j = 1;
                while (mid - i >= 0 && nums[mid - i] == target) {
                    i++;
                }
                while (mid + j < n && nums[mid + j] == target) {
                    j++;
                }
                start = mid - i + 1;
                end = mid + j - 1;
                break;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return new int[]{start, end};
    }
}
