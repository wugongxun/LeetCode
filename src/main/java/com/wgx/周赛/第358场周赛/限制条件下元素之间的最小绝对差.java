package com.wgx.周赛.第358场周赛;

import java.util.*;

/**
 * @author wgx
 * @since 2023/8/13 10:44
 */
public class 限制条件下元素之间的最小绝对差 {
    public static void main(String[] args) {
        var nums = new ArrayList<Integer>();
        nums.add(4);
        nums.add(3);
        nums.add(2);
        nums.add(4);
        System.out.println(minAbsoluteDifference(nums, 0));
    }

    public static int minAbsoluteDifference(List<Integer> nums, int x) {
        int n = nums.size();
        var set = new TreeSet<Integer>();
        int res = Integer.MAX_VALUE;
        for (int i = x; i < n; i++) {
            set.add(nums.get(i - x));
            var num = nums.get(i);
            var ceiling = set.ceiling(num);
            if (ceiling != null)
                res = Math.min(res, ceiling - num);
            var floor = set.floor(num);
            if (floor != null)
                res = Math.min(res, num - floor);
        }
        return res;
    }
}
