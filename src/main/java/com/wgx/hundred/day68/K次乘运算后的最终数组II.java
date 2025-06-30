package com.wgx.hundred.day68;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author wgx
 * @since 2024/12/14 13:02
 */
public class K次乘运算后的最终数组II {

    @Test
    public void test() {
        System.out.println(Arrays.toString(getFinalState(new int[]{2, 1, 3, 5, 6}, 5, 2)));
    }

    private final static int MOD = 1_000_000_007;

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        if (multiplier == 1)
            return nums;
        int n = nums.length;
        int mx = 0;
        var pq = new PriorityQueue<long[]>((a, b) -> a[0] != b[0] ? Long.compare(a[0], b[0]) : Long.compare(a[1], b[1]));
        for (int i = 0; i < n; i++) {
            mx = Math.max(mx, nums[i]);
            pq.offer(new long[]{nums[i], i});
        }
        for (; k > 0 && pq.peek()[0] < mx; k--) {
            long[] poll = pq.poll();
            poll[0] *= multiplier;
            pq.offer(poll);
        }
        for (int i = 0; i < n; i++) {
            long[] poll = pq.poll();
            nums[(int) poll[1]] = (int) (poll[0] % MOD * quickMul(multiplier, k / n + (i < k % n ? 1 : 0)) % MOD);
        }
        return nums;
    }

    private long quickMul(long x, int n) {
        long res = 1;
        for (; n > 0; n >>= 1) {
            if ((n & 1) == 1)
                res = res * x % MOD;
            x = x * x % MOD;
        }
        return res;
    }
}
