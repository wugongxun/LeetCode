package com.wgx.fifty.day38;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author wgx
 * @since 2023/5/1 20:55
 */
public class 通知所有员工所需的时间 {
    @Test
    public void test() {
        System.out.println(numOfMinutes(11, 4, new int[]{5,9,6,10,-1,8,9,1,9,3,4}, new int[]{0,213,0,253,686,170,975,0,261,309,337}));
    }

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        var cache = new int[n];
        Arrays.fill(cache, -1);
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dfs(manager, informTime, cache, i));
        }
        return res;
    }

    public int dfs(int[] manager, int[] informTime, int[] cache, int i) {
        if (manager[i] < 0) {
            return informTime[i];
        }
        if (cache[i] != -1) {
            return cache[i];
        }
        return cache[i] = dfs(manager, informTime, cache, manager[i]) + informTime[i];
    }


//    List<Integer>[] tree;
//    int[] informTime;
//
//    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
//        tree = new List[n];
//        Arrays.setAll(tree, i -> new ArrayList());
//        for (int i = 0; i < n; ++i) {
//            if (manager[i] != -1) {
//                tree[manager[i]].add(i);
//            }
//        }
//        this.informTime = informTime;
//        return dfs(headID);
//    }
//
//    public int dfs(int cur) {
//        if (tree[cur].size() == 0) {
//            return 0;
//        }
//        int max = 0;
//        for (var next : tree[cur]) {
//            max = Math.max(dfs(next) + informTime[cur], max);
//        }
//        return max;
//    }
}
