package com.wgx.day38;

import java.util.HashSet;

/**
 * @author wgx
 * @since 2023/5/2 20:25
 */
public class 最长连续序列 {
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }


    public static int longestConsecutive(int[] nums) {
        int n = nums.length;
        var set = new HashSet<Integer>(n);
        for (int i = 0; i < n; ++i) {
            set.add(nums[i]);
        }

        int res = 0;
        for (var num : set) {
            if (!set.contains(num - 1)) {
                int cur = num;
                int count = 1;
                while (set.contains(cur + 1)) {
                    cur++;
                    count++;
                }
                res = Math.max(res, count);
            }
        }
        return res;
    }

//    public static int longestConsecutive(int[] nums) {
//        int n = nums.length;
//        if (n == 0) {
//            return 0;
//        }
//        Arrays.sort(nums);
//        int res = 1;
//        int count = 1;
//        for (int i = 1; i < n; ++i) {
//            if (nums[i] == nums[i - 1] + 1) {
//                count++;
//            } else if (nums[i] == nums[i - 1]) {
//                continue;
//            } else {
//                res = Math.max(res, count);
//                count = 1;
//            }
//        }
//        res = Math.max(res, count);
//        return res;
//    }
}
