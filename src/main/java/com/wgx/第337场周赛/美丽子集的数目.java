package com.wgx.第337场周赛;

import java.util.Arrays;

/**
 * @author wgx
 * @since 2023/3/19 11:00
 */
public class 美丽子集的数目 {
    public static void main(String[] args) {
        System.out.println(beautifulSubsets(new int[]{4,2,5,9,10,3}, 1));
    }

    public static int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums);

        var eqs = new int[nums.length];
        Arrays.fill(eqs, -1);

        for (int i = 0; i < nums.length - 1; i++) {
            int search = Arrays.binarySearch(nums, i, nums.length, nums[i] + k);
            if (search > 0) {
                eqs[i] = search;
            }
        }

        int res = 0;
        label: for (int i = 1; i < 1 << nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (((i >> j) & 1) == 1 && eqs[j] != -1 && ((i >> eqs[j] & 1) == 1)) {
                    continue label;
                }
            }
            res++;
        }
        return res;
    }

//    public static int beautifulSubsets(int[] nums, int k) {
//        if (nums.length == 1 && k != 0) {
//            return 1;
//        }
//        int eqs = 0;
//        for (int i = 0; i < nums.length - 1; i++) {
//            int temp = nums[i];
//            if (temp - k > 0 && Arrays.binarySearch(nums, i, nums.length - 1, temp - k) > 0) {
//                eqs++;
//            }
//            if (Arrays.binarySearch(nums, i, nums.length - 1, temp + k) > 0) {
//                eqs++;
//            }
//        }
//
//        return ((1 << nums.length) - 2) - (1 << nums.length - 2) * eqs;
//    }
}
