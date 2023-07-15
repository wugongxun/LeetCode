package com.wgx.fifty.day44;

import org.junit.jupiter.api.Test;

/**
 * @author wgx
 * @since 2023/6/16 9:40
 */
public class 并行课程II {
    @Test
    public void test() {
//        System.out.println(minNumberOfSemesters(5, new int[][]{
//                {2, 1}, {3, 1}, {4, 1}, {1, 5}
//        }, 2));
        System.out.println(minNumberOfSemesters(5, new int[][]{
                {1, 5}, {1, 3}, {1, 2}, {4, 2}, {4, 5}, {2, 5}, {1, 4}, {4, 3}, {3, 5}, {3, 2}
        }, 3));
    }

//    动态规划
    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        var pre = new int[n];
        for (var relation : relations) {
            pre[relation[1] - 1] |= 1 << (relation[0] - 1);
        }
        int u = (1 << n) - 1;
        var dp = new int[1 << n];
        dp[0] = 0;
        for (int i = 1; i < 1 << n; i++) {
            int i1 = 0, ci = u ^ i;
            for (int j = 0; j < n; j++) {
                if ((i >> j & 1) == 1 && (pre[j] | ci) == ci) {
                    i1 |= 1 << j;
                }
            }
            if (Integer.bitCount(i1) <= k) {
                dp[i] = dp[i ^ i1] + 1;
                continue;
            }
            dp[i] = Integer.MAX_VALUE;
            for (int j = i1; j > 0; j = (j - 1) & i1) {
                if (Integer.bitCount(j) <= k) {
                    dp[i] = Math.min(dp[i], dp[i ^ j] + 1);
                }
            }
        }
        return dp[u];
    }


//    递归+记忆化搜索
//    先修课程集合，缓存
//    int[] pre, cache;
//    //u为所有课程的全集
//    int k, u;
//
//    public int minNumberOfSemesters(int n, int[][] relations, int k) {
//        this.k = k;
//        pre = new int[n];
//        for (var relation : relations) {
//            pre[relation[1] - 1] |= 1 << (relation[0] - 1);//relation[1]的先修课程，二进制表示
//        }
//        u = (1 << n) - 1;//全集
//        cache = new int[1 << n];
//        Arrays.fill(cache, -1);
//        return dfs(u);
//    }
//
//    public int dfs(int i) {
//        //已经全部修完
//        if (i == 0) {
//            return 0;
//        }
//        if (cache[i] != -1) {
//            return cache[i];
//        }
//        //i1为当前可以学习的课程，ci为i的补集即为已经学习完的课程
//        int i1 = 0, ci = u ^ i;
//        //遍历所有的先修课程
//        for (int j = 0; j < pre.length; j++) {
//            //pre[j]在i的补集中，表示课程j的先修课程都已修完，可以学习课程j
//            if ((i >> j & 1) == 1 && (pre[j] | ci) == ci) {
//                i1 |= 1 << j;
//            }
//        }
//        //如果可以学习的课程的数量小于k，直接全部学习
//        if (Integer.bitCount(i1) <= k) {
//            //i ^ i1为学习完i1表示的课程后剩下的课程
//            return cache[i] = dfs(i ^ i1) + 1;
//        }
//        int res = Integer.MAX_VALUE;
//        //枚举i1的子集
//        for (int j = i1; j > 0; j = (j - 1) & i1) {
//            if (Integer.bitCount(j) <= k) {
//                res = Math.min(res, dfs(i ^ j) + 1);
//            }
//        }
//        return cache[i] = res;
//    }
}
