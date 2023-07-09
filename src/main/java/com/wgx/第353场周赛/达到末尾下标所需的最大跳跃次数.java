package com.wgx.第353场周赛;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wgx
 * @since 2023/7/9 10:34
 */
public class 达到末尾下标所需的最大跳跃次数 {
    @Test
    public void test() {
//        System.out.println(maximumJumps(new int[]{1, 3, 6, 4, 1, 2}, 3));
//        System.out.println(maximumJumps(new int[]{1, 3, 6, 4, 1, 2}, 0));
        System.out.println(maximumJumps(new int[]{0, 2, 1, 3}, 1));
    }

    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        List<Integer>[] adj = new List[n];
        Arrays.setAll(adj, i -> new ArrayList<>());
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (Math.abs(nums[j] - nums[i]) <= target) {
                    adj[i].add(j);
                }
            }
        }
        var dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == -1) {
                continue;
            }
            for (var next : adj[i]) {
                dp[next] = Math.max(dp[next], dp[i] + 1);
            }
        }
        return dp[n - 1];
    }
}
