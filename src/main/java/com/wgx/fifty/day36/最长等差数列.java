package com.wgx.fifty.day36;

import org.junit.jupiter.api.Test;

/**
 * @author wgx
 * @since 2023/4/22 13:57
 */
public class 最长等差数列 {

    @Test
    public void test() {
        System.out.println(longestArithSeqLength(new int[]{20,1,15,3,10,5,8}));
    }

    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        var dp = new int[n][1001];
        int res = 0;
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; --j) {
                int diff = nums[i] - nums[j] + 500;
                if (dp[i][diff] == 0) {
                    dp[i][diff] = dp[j][diff] + 1;
                    res = Math.max(res, dp[i][diff]);
                }
            }
        }
        return res + 1;
    }


    //dp
//    public int longestArithSeqLength(int[] nums) {
//        int n = nums.length;
//        Map<Integer, Integer>[] lens = new Map[n];
//        Arrays.setAll(lens, i -> new HashMap<>());
//        int res = 0;
//        for (int i = 1; i < n; i++) {
//            lens[i] = new HashMap<>();
//            for (int j = i - 1; j >= 0; --j) {
//                int diff = nums[i] - nums[j];
//                if (!lens[i].containsKey(diff)) {
//                    lens[i].put(diff, lens[j].getOrDefault(diff, 1) + 1);
//                    res = Math.max(res, lens[i].get(diff));
//                }
//            }
//        }
//        return res;
//    }


    //dfs
//    Map<Integer, Integer>[] lens;
//    int[] nums;
//    int res;
//
//    public int longestArithSeqLength(int[] nums) {
//        int n = nums.length;
//        this.lens = new Map[n];
//        this.nums = nums;
//        for (int i = 1; i < n; i++) {
//            dfs(i);
//        }
//        return res;
//    }
//
//    public Map<Integer, Integer> dfs(int index) {
//        if (lens[index] != null) {
//            return lens[index];
//        }
//
//        lens[index] = new HashMap<>();
//        for (int i = index - 1; i >= 0; --i) {
//            int diff = nums[index] - nums[i];
//            if (!lens[index].containsKey(diff)) {
//                lens[index].put(diff, dfs(i).getOrDefault(diff, 1) + 1);
//                res = Math.max(res, lens[index].get(diff));
//            }
//        }
//        return lens[index];
//    }
}
