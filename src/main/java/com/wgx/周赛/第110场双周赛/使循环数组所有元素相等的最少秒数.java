package com.wgx.周赛.第110场双周赛;

import java.util.*;

/**
 * @author wgx
 * @since 2023/8/5 22:49
 */
public class 使循环数组所有元素相等的最少秒数 {
    public static void main(String[] args) {
        var nums = new ArrayList<Integer>();
        //[13,1,12,14,8,11,3,13,15,3,4]
        nums.add(13);
        nums.add(1);
        nums.add(12);
        nums.add(14);
        nums.add(8);
        nums.add(11);
        nums.add(3);
        nums.add(13);
        nums.add(15);
        nums.add(3);
        nums.add(4);
        System.out.println(minimumSeconds(nums));
    }


    public static int minimumSeconds(List<Integer> nums) {
        int n = nums.size();
        var map = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < n; ++i) {
            if (map.containsKey(nums.get(i))) {
                map.get(nums.get(i)).add(i);
            } else {
                var list = new ArrayList<Integer>();
                list.add(i);
                map.put(nums.get(i), list);
            }
        }
        int res = Integer.MAX_VALUE;
        for (var entry : map.entrySet()) {
            int time = 0;
            var list = entry.getValue();
            int size = list.size();
            if (size == 1) {
                continue;
            }
            for (int i = 0; i < size - 1; i++) {
                time = Math.max(time, (list.get(i + 1) - list.get(i)) / 2);
            }
            time = Math.max(time, (n - list.get(size - 1) + list.get(0)) / 2);
            res = Math.min(res, time);
        }
        return res == Integer.MAX_VALUE ? n / 2 : res;
    }
}
