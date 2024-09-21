package com.wgx.hundred.day68;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * @author wgx
 * @since 2024/7/4 21:45
 */
public class 拾起K个1需要的最少行动次数 {

    @Test
    public void test() {
//        System.out.println(minimumMoves(new int[]{1, 1, 0, 0, 0, 1, 1, 0, 0, 1}, 3, 1));
//        System.out.println(minimumMoves(new int[]{1, 0, 1, 0, 1}, 3, 0));
//        System.out.println(minimumMoves(new int[]{1, 1}, 2, 4));
        System.out.println(minimumMoves(new int[]{1, 0, 0, 0, 0, 1}, 2, 0));
    }

    public long minimumMoves(int[] nums, int k, int maxChanges) {
        var pos = new ArrayList<Integer>();
        int c = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                continue;
            pos.add(i);
            c = Math.max(c, 1);
            if (i > 0 && nums[i - 1] == 1) {
                if (i > 1 && nums[i - 2] == 1) {
                    c = 3;
                } else {
                    c = Math.max(c, 2);
                }
            }
        }

        c = Math.min(c, k);
        if (maxChanges >= k - c) {
            return Math.max(c - 1, 0) + (k - c) * 2L;
        }

        int n = pos.size();
        var prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + pos.get(i);
        }

        long res = Long.MAX_VALUE;
        int size = k - maxChanges;
        for (int r = size; r <= n; r++) {
            int l = r - size;
            int mid = (r + l) / 2;
            long index = pos.get(mid);
            long s1 = index * (mid - l) - (prefix[mid] - prefix[l]);
            long s2 = prefix[r] - prefix[mid] - index * (r - mid);
            res = Math.min(res, s1 + s2);
        }
        return res + maxChanges * 2L;
    }

}
