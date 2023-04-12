package com.wgx.day33;

/**
 * @author wgx
 * @since 2023/4/11 10:22
 */
public class 不同的二叉搜索树 {
    public static void main(String[] args) {
        System.out.println(numTrees(4));
    }

    //dp
    public static int numTrees(int n) {
        var dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

    //递归+记忆化搜索
//    static Map<Integer, Integer> cache;
//
//    public static int numTrees(int n) {
//        cache = new HashMap<>();
//        return dfs(n);
//    }
//
//    public static int dfs(int n) {
//        if (n <= 1) {
//            return 1;
//        }
//        if (cache.containsKey(n)) {
//            return cache.get(n);
//        }
//
//        int res = 0;
//        for (int i = 0; i < n; i++) {
//            res += dfs(i) * dfs(n - i - 1);
//        }
//        cache.put(n, res);
//        return res;
//    }
}
