package com.wgx.day48;

/**
 * @author wgx
 * @since 2023/7/8 18:14
 */
public class 寻找旋转排序数组中的最小值 {
    public static void main(String[] args) {
//        System.out.println(findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.println(findMin(new int[]{11, 13, 15, 17}));
    }

    public static int findMin(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        int mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
