package com.wgx.day16;

import com.wgx.day12.神奇字符串;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wgx
 * @since 2023/1/12 11:16
 *
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */
public class 全排列 {
    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
    }

    public static List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> list = new ArrayList<>();
        backtrack(list, 0, nums);
        return list;
    }

    public static List<List<Integer>> dfs(int[] nums, List<Integer> used) {
        if (nums.length == used.size()) {
            ArrayList<List<Integer>> list = new ArrayList<>();
            list.add(new ArrayList());
            return list;
        }
        ArrayList<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!used.contains(nums[i])) {
                ArrayList<Integer> curUsed = new ArrayList<>(used);
                curUsed.add(nums[i]);
                List<List<Integer>> prev = dfs(nums, curUsed);
                for (List<Integer> list : prev) {
                    list.add(nums[i]);
                    res.add(list);
                }
            }
        }
        return res;
    }

    //前序遍历回溯
    public static void backtrack(List<List<Integer>> list, List<Integer> used, int[] nums) {
        if (used.size() == nums.length) {
            list.add(new ArrayList<>(used));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used.contains(nums[i])) {
                continue;
            }
            used.add(nums[i]);
            backtrack(list, used, nums);
            used.remove(used.size() - 1);
        }
    }

    //交换回溯
    public static void backtrack(List<List<Integer>> res, int index, int[] nums) {
        if (index == nums.length - 1) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            res.add(list);
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            backtrack(res, index + 1, nums);
            swap(nums, i, index);
        }
    }
    public static void swap(int[] nums, int i, int j) {
        if (i != j) {
            nums[i] ^= nums[j];
            nums[j] ^= nums[i];
            nums[i] ^= nums[j];
        }
    }
}
