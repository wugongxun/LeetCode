package com.wgx.day1;

import java.util.HashSet;

/**
 * @author wgx
 * @version 1.0
 * @since 2022/9/25 14:46
 */
public class 存在重复元素 {
    public static void main(String[] args) {

    }
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) return true;
        }
        return false;
    }
}
