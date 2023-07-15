package com.wgx.周赛.第344场周赛;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author wgx
 * @since 2023/5/7 10:39
 */
public class 找出不同元素数目差数组 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(distinctDifferenceArray(new int[]{3,2,3,4,2})));
    }

    public static int[] distinctDifferenceArray(int[] nums) {
        int n = nums.length;
        var prefix = new int[n];
        var suffix = new int[n + 1];
        var set = new HashSet<Integer>();
        for (int i = 0; i < n; ++i) {
            set.add(nums[i]);
            prefix[i] = set.size();
        }
        set.clear();
        for (int i = n - 1; i >= 0; --i) {
            set.add(nums[i]);
            suffix[i] = set.size();
        }

        var res = new int[n];
        for (int i = 0; i < n; ++i) {
            res[i] = prefix[i] - suffix[i + 1];
        }
        return res;
    }
}
