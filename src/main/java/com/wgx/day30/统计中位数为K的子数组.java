package com.wgx.day30;

import java.util.HashMap;

/**
 * @author wgx
 * @since 2023/3/16 9:34
 */
public class 统计中位数为K的子数组 {
    public static void main(String[] args) {
        System.out.println(countSubarrays(new int[]{2, 5, 1, 4, 3, 6}, 1));
    }


    public static int countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) {
                index = i;
                break;
            }
        }


        var counts = new HashMap<Integer, Integer>();
        counts.put(0, 1);
        int res = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i] > k ? 1 : (nums[i] == k ? 0 : -1);
            if (i < index) {
                counts.put(sum, counts.getOrDefault(sum, 0) + 1);
            } else {
                int prev0 = counts.getOrDefault(sum, 0);
                int prev1 = counts.getOrDefault(sum - 1, 0);
                res += prev0 + prev1;
            }
        }
        return res;
    }

    //超时
//    public static int countSubarrays(int[] nums, int k) {
//        int n = nums.length;
//        int index = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == k) {
//                index = i;
//                break;
//            }
//        }
//
//
//        //前缀和
//        var prefix = new int[n + 1];
//        for (int i = 0; i < n; i++) {
//            prefix[i + 1] = prefix[i] + (nums[i] > k ? 1 : 0);
//        }
//
//        index++;
//        int res = 0;
//        for (int i = 0; i < n; i++) {
//            int left = Math.max(index - i, 1);
//            int right = Math.min(index + i, n);
//            for (int j = left; j + i <= right; j++) {
//                int dif = prefix[j + i] - prefix[j - 1];
//                if (dif == (i + 1) / 2) {
//                    res++;
//                }
//            }
//
//        }
//        return res;
//    }
}
