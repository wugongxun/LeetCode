package com.wgx.fifty.day35;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wgx
 * @since 2023/4/17 11:38
 */
public class 组合总和 {
    public static void main(String[] args) {

    }

    List<List<Integer>> res;
    int n;
    int target;
    List<Integer> path;
    int[] candidates;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.res = new ArrayList<>();
        this.n = candidates.length;
        this.target = target;
        this.path = new ArrayList<Integer>();
        this.candidates = candidates;
        Arrays.sort(candidates);
        dfs(0, 0);
        return res;
    }

    public void dfs(int index, int sum) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < n; ++i) {
            if (sum + candidates[i] > target) {
                break;
            }
            path.add(candidates[i]);
            dfs(i, sum + candidates[i]);
            path.remove(path.size() - 1);
        }

    }
}
