package com.wgx.fifty.day17;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wgx
 * @since 2023/1/17 10:45
 */
public class 子集 {
    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1,2,3}));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        subsets(nums, 0, new ArrayList<>(), res);
        return res;
    }

    public static void subsets(int[] nums, int index, List<Integer> curList, List<List<Integer>> res) {
        if (index == nums.length) {
            ArrayList<Integer> list = new ArrayList<>(curList);
            res.add(list);
            return;
        }
        int num = nums[index];
        curList.add(num);
        subsets(nums, index + 1, curList, res);
        curList.remove(curList.size() - 1);
        subsets(nums, index + 1, curList, res);
    }
}
