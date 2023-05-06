package com.wgx.day39;

import java.util.Arrays;

/**
 * @author wgx
 * @since 2023/5/6 10:22
 */
public class 下一个排列 {
    public static void main(String[] args) {
        int[] arr = {4, 2, 0, 2, 3, 2, 0};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        int n = nums.length;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = n - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            nums[i] = nums[i] + nums[j];
            nums[j] = nums[i] - nums[j];
            nums[i] = nums[i] - nums[j];
        }
        int left = i, right = n - 1;
        while (left < right) {
            nums[left] = nums[left] + nums[right];
            nums[right] = nums[left] - nums[right];
            nums[left] = nums[left] - nums[right];
            left++;
            right--;
        }

    }

//    public static void nextPermutation(int[] nums) {
//        int n = nums.length;
//        int formIndex = -1;
//        for (int i = n - 1; i >= 0; --i) {
//            if (formIndex != -1) {
//                break;
//            }
//            int t = -1;
//            for (int j = i + 1; j < n; ++j) {
//                if (nums[i] < nums[j]) {
//                    t = j;
//                }
//            }
//            if (t != -1) {
//                nums[i] ^= nums[t];
//                nums[t] ^= nums[i];
//                nums[i] ^= nums[t];
//                formIndex = i;
//            }
//        }
//        Arrays.sort(nums, formIndex + 1, n);
//    }
}
