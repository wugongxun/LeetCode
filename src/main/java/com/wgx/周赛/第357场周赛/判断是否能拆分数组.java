package com.wgx.周赛.第357场周赛;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wgx
 * @since 2023/8/6 10:37
 */
public class 判断是否能拆分数组 {
    public static void main(String[] args) {
        var nums = new ArrayList<Integer>();
        //[4, 1, 3, 2, 4]
        nums.add(4);
        nums.add(1);
        nums.add(3);
        nums.add(2);
        nums.add(4);
        System.out.println(canSplitArray(nums, 6));
    }

    public static boolean canSplitArray(List<Integer> nums, int m) {
        int n = nums.size();
        if (n <= 2) {
            return true;
        }
        for (int i = 1; i < n; i++) {
            if (nums.get(i) + nums.get(i - 1) >= m) {
                return true;
            }
        }
        return false;
    }
}
