package com.wgx.day47;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author wgx
 * @since 2023/6/28 20:25
 */
public class 最小不兼容性 {
    @Test
    public void test() {
//        System.out.println(minimumIncompatibility(new int[]{1, 2, 1, 4}, 2));
        System.out.println(minimumIncompatibility(new int[]{6, 3, 8, 1, 3, 1, 2, 2}, 4));
    }



    public int minimumIncompatibility(int[] nums, int k) {
        int n = nums.length, group = n / k, inf = Integer.MAX_VALUE;
        var dp = new int[1 << n];
        Arrays.fill(dp, inf);
        dp[0] = 0;
        var values = new HashMap<Integer, Integer>();

        for (int mask = 1; mask < (1 << n); ++mask) {
            if (Integer.bitCount(mask) != group) {
                continue;
            }
            int min = 20, max = 0;
            var set = new HashSet<Integer>();
            for (int i = 0; i < n; ++i) {
                if ((mask >> i & 1) == 1) {
                    if (set.contains(nums[i])) {
                        break;
                    }
                    set.add(nums[i]);
                    min = Math.min(min, nums[i]);
                    max = Math.max(max, nums[i]);
                }
            }
            if (set.size() == group) {
                values.put(mask, max - min);
            }
        }

        for (int mask = 0; mask < 1 << n; ++mask) {
            if (dp[mask] == inf) {
                continue;
            }
            var seen = new HashMap<Integer, Integer>();
            for (int i = 0; i < n; ++i) {
                if ((mask >> i & 1) == 0) {
                    seen.put(nums[i], i);
                }
            }
            if (seen.size() < group) {
                continue;
            }
            int sub = 0;
            for (var v : seen.values()) {
                sub |= 1 << v;
            }
            int next = sub;
            while (next > 0) {
                if (values.containsKey(next)) {
                    dp[mask | next] = Math.min(dp[mask | next], dp[mask] + values.get(next));
                }
                next = (next - 1) & sub;
            }
        }

        return (dp[(1 << n) - 1] < inf ? dp[(1 << n) - 1] : -1);
    }

}
